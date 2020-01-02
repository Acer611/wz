package com.swtl.wz.service.user;

import com.swtl.wz.entity.po.user.User;
import com.swtl.wz.entity.po.user.UserEducation;
import com.swtl.wz.entity.po.user.UserRegesiterRequset;
import com.swtl.wz.entity.po.user.UserWorkExperience;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 用户service 接口
 */
public interface IUserService {
    /**
     * 获取用户基本信息根据用户ID
     * @param userId
     * @return
     */
    UserResponse findUserById(Long userId);

    /**
     * 根据用户ID x修改完善用户基本信息
     * @param user
     * @return
     */
    UserResponse modifyUser(User user);

    /**
     * 上传 修改用户头像
     * @param file
     * @param
     * @param userId
     * @return
     */
    UserResponse uploadFaceImage(MultipartFile file, Long userId);

    /**
     * 用户注册
     * @param userRegesiterRequset
     * @return
     */
    UserResponse register(UserRegesiterRequset userRegesiterRequset,String channel);

    /**
     * 发送短信验证码
     * @param phone
     * @return
     */
    UserResponse sendCode(String phone,String IP);

    /**
     * 用户登录
     * @param userRegesiterRequset
     * @return
     */
    UserResponse login(UserRegesiterRequset userRegesiterRequset);

    /**
     * 用户登出
     * @param useId
     * @return
     */
    UserResponse loginOut(String useId);

    /**
     *修改密码 通过验证码修改密码
     * @param userRegesiterRequset
     * @return
     */
    UserResponse resetPassword(UserRegesiterRequset userRegesiterRequset);

    /**
     * 保存用户的教育信息
     * @param userEducation
     * @return
     */
    UserResponse saveUserEducation(UserEducation userEducation);

    /**
     * 保存用户工作经历
     * @param workExperience
     * @return
     */
    UserResponse saveUserWorkExperience(UserWorkExperience workExperience);

    /**
     * 修改上传个人照片
     * @param file
     * @param l
     * @return
     */
    UserResponse uploadPhoto(MultipartFile file, long l);

    /**
     * 查询用户实体信息
     * @param userId
     * @return
     */
    User getUserEntity(String userId);
}
