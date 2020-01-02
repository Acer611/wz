package com.swtl.wz.service.user.impl;

import cn.jiguang.common.utils.StringUtils;
import com.github.pagehelper.util.StringUtil;
import com.swtl.wz.common.constant.Constant;
import com.swtl.wz.common.constant.ErrorConstant;
import com.swtl.wz.common.utils.*;
import com.swtl.wz.dao.user.UserEducationMapper;
import com.swtl.wz.dao.user.UserMapper;
import com.swtl.wz.entity.po.user.*;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import com.swtl.wz.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *用户service  层接口
 */
@Service("userService")
public class UserServiceImpl  implements IUserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserEducationMapper userEducationMapper;


    //文件上传路径
    @Value("${file.upload.path}")
    private  String uploadPath;
    //域名地址
    @Value("${domain.path}")
    private String domainUrl;
    //上传文件允许的大小
    @Value("${spring.servlet.multipart.max-file-size}")
    private Integer maxFileSize;
    /** 短信验证码的地址 */
    @Value("${sms.sendCode.url}")
    private String smsSendCodeUrl ;
    /** 短信验证码参数前缀 */
    @Value("${sms.sendCode.message.prefixx}")
    private String smsSendCodePramPrefixx ;



    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据用户ID 查询用户基本信息
     * @param userId
     * @return
     */
    @Override
    public UserResponse findUserById(Long userId) {

        User user = userMapper.selectUserByID(userId);
        String schedule = stringRedisTemplate.opsForValue().get(Constant.USER_INFO_SCHEDULE + userId);
        if(schedule==null){
            schedule = getUserInfoSchedule(user.getId());
        }
        user.setSchedule(schedule);
        if(user==null){
            return UserResponse.creteUserNotExsit();
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);

        return userResponse;
    }


    /**
     * 根据用户ID  修改完善用户基本信息
     * @param user
     * @return
     */
    @Override
    public UserResponse modifyUser(User user) {
        UserResponse userResponse = new UserResponse();

        //判断用户是否存在
        User exsituser = userMapper.selectUserByID(user.getId());
        if(exsituser==null){
            return UserResponse.creteUserNotExsit();
        }
        user.setUpdateTime(new Date());
        //修改用户基本信息
        userMapper.updateUser(user);

        //简历完整度更新
        String userInfoSchedule = getUserInfoSchedule(user.getId());
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + user.getId(),userInfoSchedule );
        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("修改用户基本信息成功！");
        return userResponse;
    }

    /**
     * 上传修改用户头像
     * @param file
     * @param userId
     * @return
     */
    @Override
    public UserResponse uploadFaceImage(MultipartFile file, Long userId) {
        UserResponse userResponse = new UserResponse();
        //判断文件大小
        if(file.getSize()>maxFileSize){
            return UserResponse.createFileTooMaxResponse();
        }

        //文件上传
        String fileName =  FileUtils.fileUpload(file,uploadPath);

        //修改用户基本信息
        User user = new User();
        user.setId(userId);
        user.setFaceUrl(domainUrl + fileName);
        userMapper.updateUser(user);

        user = userMapper.selectUserByID(userId);

        //简历完整度更新
        String userInfoSchedule = getUserInfoSchedule(userId);
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + userId,userInfoSchedule );

        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("修改用户个人头像成功！");
        userResponse.setUser(user);
        return userResponse;
    }

    /**
     * 用户注册
     * @param userRegesiterRequset
     * @return
     */
    @Override
    public UserResponse register(UserRegesiterRequset userRegesiterRequset,String channel) {
        UserResponse userResponse = new UserResponse();

        // 检验手机号是否被注册
        User mobileUser = userMapper.findUserByPhone(userRegesiterRequset.getMobile());
        if(mobileUser != null){
            return UserResponse.createMobileHaveExsitResponse();
        }
        // 检验验证码是否匹配
        String checkCode = stringRedisTemplate.opsForValue().get(Constant.REGISTER_PREFIX + userRegesiterRequset.getMobile());
        //验证码已经失效
        if(StringUtil.isEmpty(checkCode)){
            return UserResponse.CheckCodeInvalidResponse();
        }

        //验证码不匹配
        if(!userRegesiterRequset.getCheckCode().equalsIgnoreCase(checkCode)){
            return UserResponse.CheckCodeNotMatchResponse();
        }

        User user = new User();
        user.setMobile(userRegesiterRequset.getMobile());
        //注册简历完整度为10%
        Long maxId = userMapper.finMaxID();
        //加密密码
        String password = MD5.MD5Encode(userRegesiterRequset.getPassword());
        user.setPassword(password);
        user.setName("用户"+maxId+1);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setChannel(channel);
        // 保存用户信息
        userMapper.insertUser(user);


        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + maxId,"10%" );

        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("注册成功！");
        return userResponse;
    }

    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    @Override
    public UserResponse sendCode(String phone,String IP) {

        UserResponse userResponse = new UserResponse();
        //检验一分钟内是否重复发送验证码
        String checkCode = stringRedisTemplate.opsForValue().get(Constant.REGISTER_PREFIX + phone);
        if (checkCode != null || !StringUtils.isEmpty(checkCode)) {
            return  UserResponse.CodeSendTooFastResponse();
        }

        //检验当天验证码发送次数
        int times = 0;
        if (stringRedisTemplate.hasKey(Constant.REGISTER_COUNT_PREFIX + phone)) {
            times = Integer.parseInt(stringRedisTemplate.opsForValue().get(Constant.REGISTER_COUNT_PREFIX + phone));
        }
        //当天短信发送次数超限
        if (times >= Constant.MESSAGE_MAX_SEND_TIMES) {
            return  UserResponse.SendCodeDayLimitResponse();
        }

        /** 发送手机验证码 */

        //生成四位验证码
        String code = ShareCode.generateCodeFour();
        if(StringUtil.isEmpty(code)){
            return  UserResponse.generateCodeErrorResponse();
        }
        //发送手机验证码
        sendCheckCode(phone,code);

        //把手机号和发送验证码的存入Redis 并且设置过期时间为60秒
        stringRedisTemplate.opsForValue().set(Constant.REGISTER_PREFIX + phone, code, 60, TimeUnit.SECONDS);

        //把当前手机号发送验证码次数存入redis  每发一次计数加一  每天24点清除
        stringRedisTemplate.boundValueOps(Constant.REGISTER_COUNT_PREFIX + phone).increment(1);
        Long expireTime = getExpireTime();
        stringRedisTemplate.expire(Constant.REGISTER_COUNT_PREFIX + phone, expireTime, TimeUnit.MINUTES);

        //保存验证码信息
        saveCheckCode(phone, IP, code);

        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("发送短信验证码成功");
        return userResponse;
    }

    /**
     * 用户登录接口
     * @param userRegesiterRequset
     * @return
     */
    @Override
    public UserResponse login(UserRegesiterRequset userRegesiterRequset) {
        UserResponse userResponse = new UserResponse();
        String password = userRegesiterRequset.getPassword();
        password =  MD5.MD5Encode(password);
        String mobile = userRegesiterRequset.getMobile();
        User user = userMapper.finUserByPhonePass(mobile,password);
        if(user==null){
            userResponse.setRetCode(-1);
            userResponse.setRetMsg("账号密码错误！");
            return userResponse;
        }


        //新登录用户踢出老登录用户的信息
        String oldToken = stringRedisTemplate.opsForValue().get("User_GetTokenByUser:" + user.getId());
        stringRedisTemplate.delete("User_GetTokenByUser:" + user.getId());
        stringRedisTemplate.delete("User_GetUserByToken:" + oldToken);


        //生成根据用户信息token （生成规则 MD5(ip+phone+当前时间)）
        String token = MD5.MD5Encode(user.getId()+ user.getMobile()+ new Date());
        //String userInfoStr = JSON.toJSON(userInfo).toString();
        stringRedisTemplate.opsForValue().set("User_GetUserByToken:" + token,  user.getId()+"", 30, TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set("User_GetTokenByUser:" + user.getId(),  token, 30, TimeUnit.DAYS);

        userResponse.setUser(user);
        userResponse.setToken(token);
        return userResponse;
    }

    /**
     * 用户登出
     * @param useId
     * @return
     */
    @Override
    public UserResponse loginOut(String useId) {
        UserResponse userResponse = new UserResponse();
        String oldToken = stringRedisTemplate.opsForValue().get("User_GetTokenByUser:" + useId);
        stringRedisTemplate.delete("User_GetTokenByUser:" + useId);
        stringRedisTemplate.delete("User_GetUserByToken:" + oldToken);
        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("用户登出成功！");
        return  userResponse;
    }

    /**
     * 修改密码
     * @param userRegesiterRequset
     * @return
     */
    @Override
    public UserResponse resetPassword(UserRegesiterRequset userRegesiterRequset) {
        UserResponse userResponse = new UserResponse();
        // 检验验证码是否匹配
        String checkCode = stringRedisTemplate.opsForValue().get(Constant.REGISTER_PREFIX + userRegesiterRequset.getMobile());
        //验证码已经失效
        if(StringUtil.isEmpty(checkCode)){
            return UserResponse.CheckCodeInvalidResponse();
        }

        //验证码不匹配
        if(!userRegesiterRequset.getCheckCode().equalsIgnoreCase(checkCode)){
            return UserResponse.CheckCodeNotMatchResponse();
        }

        String password = userRegesiterRequset.getPassword();
        password = MD5.MD5Encode(password);
        //修改密码
        userMapper.updateUserPassword(userRegesiterRequset.getMobile(),password);
        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("修改密码成功！");
        return userResponse;
    }

    /**
     * 保存用户的教育信息
     * @param userEducation
     * @return
     */
    @Override
    public UserResponse saveUserEducation(UserEducation userEducation) {
        UserResponse userResponse = new UserResponse();
        if(userEducation!=null){
            if(userEducation.getId()!=null&&userEducation.getId()>0){
                userEducation.setUpdateTime(new Date());
                userEducationMapper.updateUserEducation(userEducation);
            }else{
                userEducation.setCreateTime(new Date());
                userEducationMapper.saveUserEducation(userEducation);
            }
        }

        //简历完整度更新
        Long userId = userEducation.getUserId();
        String userInfoSchedule = getUserInfoSchedule(userId);
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + userId,userInfoSchedule );

        userResponse.setRetMsg("保存修改用户教育信息成功！");
        return userResponse;
    }

    /**
     * 保存用户的工作经历
     * @param workExperience
     * @return
     */
    @Override
    public UserResponse saveUserWorkExperience(UserWorkExperience workExperience) {
        UserResponse userResponse = new UserResponse();
        if(workExperience!=null){
            if(workExperience.getId()!=null&&workExperience.getId()>0){
                workExperience.setUpdatetime(new Date());
                userEducationMapper.updateUserWorkExperience(workExperience);
            }else{
                workExperience.setCreateTime(new Date());
                userEducationMapper.saveUserWorkExperience(workExperience);
            }
        }

        //简历完整度更新
        Long userId = workExperience.getUserId();
        String userInfoSchedule = getUserInfoSchedule(userId);
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + userId,userInfoSchedule );
        userResponse.setRetMsg("保存修改用户的工作经历成功！");
        return userResponse;
    }

    /**
     * 修改上传个人照片
     * @param file
     * @param userId
     * @return
     */
    @Override
    public UserResponse uploadPhoto(MultipartFile file, long userId) {
        UserResponse userResponse = new UserResponse();
        //判断文件大小
        if(file.getSize()>maxFileSize){
            return UserResponse.createFileTooMaxResponse();
        }

        //文件上传
        String fileName =  FileUtils.fileUpload(file,uploadPath);

        //修改用户基本信息
        User user = new User();
        user.setId(userId);
        user.setPhoto(domainUrl + fileName);
        userMapper.updateUser(user);

        //简历完整度更新
        String userInfoSchedule = getUserInfoSchedule(userId);
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + userId,userInfoSchedule );

        user = userMapper.selectUserByID(userId);
        userResponse.setRetCode(ErrorConstant.SUCCESS);
        userResponse.setRetMsg("修改用个人照片成功！");
        userResponse.setUser(user);
        return userResponse;
    }

    /**
     * 查找用户实体信息
     * @param userId
     * @return
     */
    @Override
    public User getUserEntity(String userId) {
        User user = userMapper.selectUserByID(Long.parseLong(userId));
        String schedule = stringRedisTemplate.opsForValue().get(Constant.USER_INFO_SCHEDULE + userId);
        if(schedule==null){
            schedule = getUserInfoSchedule(user.getId());
        }
        user.setSchedule(schedule);
       return user;
    }

    /**
     * 简历完成度组成
     * @param userId
     * @return
     */
    private String getUserInfoSchedule(long userId) {

        //SELECT id,mobile(10&),faceUrl(2%),`name`(2%),sex(2%),education(2%),birthyear(2%),birthday(2%),identity(2%),
        // height(2%),weight(2%),address(2%),
        // wechat(2%),qq(2%),mail(2%),descrption(2%),photo(2%),relaName(10%),id_card (10%)FROM t_user WHERE id =9
        // 50%
        //教育信息 20%
        //工作经历 20%
        User user = userMapper.finUserInfoByID(userId);
        int scheduleNumber = 10;

        if(user.getFaceUrl()!=null){
            scheduleNumber += 2;
        }
        if(user.getName()!= null){
            scheduleNumber += 2;
        }
        if (user.getSex()!=null){
            scheduleNumber += 2;
        }
        if (user.getEducation()!=null){
            scheduleNumber += 2;
        }
        if (user.getBirthyear()!=null){
            scheduleNumber += 2;
        }
        if (user.getBirthday()!=null){
            scheduleNumber += 2;
        }
        if (user.getIdentity()!=null){
            scheduleNumber += 2;
        }
        if (user.getHeight()!=null){
            scheduleNumber += 2;
        }
        if (user.getWeight()!=null){
            scheduleNumber += 2;
        }
        if (user.getAddress()!=null){
            scheduleNumber += 2;
        }
        if (user.getWechat()!=null){
            scheduleNumber += 2;
        }
        if (user.getQq()!=null){
            scheduleNumber += 2;
        }

        if (user.getMail()!=null){
            scheduleNumber += 2;
        }
        if (user.getDescrption()!=null){
            scheduleNumber += 2;
        }
        if (user.getPhoto()!=null){
            scheduleNumber += 2;
        }

        if (user.getRelaName()!=null){
            scheduleNumber += 10;
        }
        if (user.getId_card()!=null){
            scheduleNumber += 10;
        }

        //获取教育经历
        List<UserEducation> userEducationList = userEducationMapper.findUserEducationByUserId(userId);
        if(userEducationList.size()>0){
            scheduleNumber += 20;
        }
        //工作经历
        List<UserWorkExperience> userWorkExperienceList = userEducationMapper.findUserWorkExperience(userId);
        if(userWorkExperienceList.size()>0){
            scheduleNumber += 20;
        }
        stringRedisTemplate.opsForValue().set(Constant.USER_INFO_SCHEDULE + userId,scheduleNumber + "%" );
        return  scheduleNumber + "%";



    }

    /**
     * 发送验证码
     * @param phone
     * @param code
     */
    private void sendCheckCode(String phone, String code) {

        String url = smsSendCodeUrl + phone + smsSendCodePramPrefixx + Constant.APP_NAME_PREFIX + code + Constant.APP_NAME_SUFFIX;
        HttpClientUtils.httpGetSMS(url);

    }

    /**
     * 保存短信验证码信息
     * @param phone
     * @param ip
     * @param code
     */
    private void saveCheckCode(String phone, String ip, String code) {
        //先检查当前手机号是否已经存在若存在更新megID 否则插入新数据
        CheckCode checkCodeEntity = userMapper.findCheckCodeBYPhone(phone);
        if(checkCodeEntity!=null){
            userMapper.deleteCheckCodeByPhone(phone);
        }
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime expireAt = dateTime.plusMinutes(5);
        CheckCode checkCode = new CheckCode();
        checkCode.setId(UUIDUtil.getUuidStr().replace("-",""));
        checkCode.setCreateAt(dateTime);
        checkCode.setPhone(phone);
        checkCode.setIp(ip);
        checkCode.setExpireAt(expireAt);
        checkCode.setCheckCode(code);
        checkCode.setIsUse(0);
        checkCode.setDelFlag(0);
        userMapper.saveCheckCode(checkCode);
    }

    //获取要设置的过期时间
    private Long getExpireTime() {
        //计算当前时间到凌晨的时间
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime tommorrow_start = today_start.plusDays(1);
        Duration between = Duration.between(now, tommorrow_start);
        return between.toMinutes();

    }
}
