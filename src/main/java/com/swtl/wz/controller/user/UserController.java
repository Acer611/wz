package com.swtl.wz.controller.user;


import com.swtl.wz.entity.po.user.User;
import com.swtl.wz.entity.po.user.UserEducation;
import com.swtl.wz.entity.po.user.UserWorkExperience;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import com.swtl.wz.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(tags = "用户操作接口" ,value = "用户操作接口",description = "用户的相关操作，包括 获取用户信息，修改密码，修改个人信息等的接口  ")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 根据用户ID  获取用户基本信息
     * @return
     */
    @ApiOperation(value = "获取的基本信息", notes = "获取用户的基本信息")
    @RequestMapping(value = "/findUserById", method = RequestMethod.GET)
    @ResponseBody
    public UserResponse findUserById(@RequestHeader(required = true, value = "token") String token){
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            return  UserResponse.creteUserNotExsit();
        }


        UserResponse userResponse = userService.findUserById(Long.parseLong(userId));
        userResponse.setToken(token);
        return userResponse;
    }


    /**
     * 修改完善用户基本信息
     * @param user
     * @return
     */
    @ApiOperation(value = "修改完善基本信息", notes = "修改完善用户基本信息,包含个人详细信息、认证信息、身高体重等基本信息")
    @RequestMapping(value = "/perfectUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse modifyUser(@RequestHeader(required = true, value = "token") String token,
            @ApiParam(value = "用户实体", required = true) @RequestBody User user){
        UserResponse userResponse = new UserResponse();
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if(userId==null){
            return UserResponse.creteUserNotExsit();
        }
        user.setId(Long.parseLong(userId));
        userResponse = userService.modifyUser(user);

        //查找用户基本信息
        User newUser = userService.getUserEntity(userId);
        userResponse.setUser(newUser);
        userResponse.setToken(token);
        return  userResponse;
    }

    /**
     * 修改 上传头像
     * @param file
     * @return
     */
    @ApiOperation(value = "上传头像", notes = "包含 上传头像和修改头像")
    @RequestMapping(value = "/uploadFaceImage", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse uploadFaceImage(@RequestHeader(required = true, value = "token") String token,
                                        @RequestParam("file") MultipartFile file){

        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            return  UserResponse.creteUserNotExsit();
        }
        //判断非空
        if (file.isEmpty()) {
            return UserResponse.createNotFaceFileResponse();
        }


        //上传修改用户头像
        UserResponse userResponse = userService.uploadFaceImage(file,Long.parseLong(userId));
        //查找用户基本信息
        User newUser = userService.getUserEntity(userId);
        userResponse.setUser(newUser);
        userResponse.setToken(token);
        return userResponse;
    }

    /**
     * 修改 个人照片
     * @param file
     * @return
     */
    @ApiOperation(value = "上传个人照片", notes = "包含 上传和修改人人照片 目前只支持 一张")
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse uploadPhoto(@RequestHeader(required = true, value = "token") String token,
                                        @RequestParam("file") MultipartFile file){

        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            return  UserResponse.creteUserNotExsit();
        }
        //判断非空
        if (file.isEmpty()) {
            return UserResponse.createNotFaceFileResponse();
        }


        //上传修改用户头像
        UserResponse userResponse = userService.uploadPhoto(file,Long.parseLong(userId));
        //查找用户基本信息
        User newUser = userService.getUserEntity(userId);
        userResponse.setUser(newUser);
        userResponse.setToken(token);
        return userResponse;
    }


    /**
     * 保存用户的教育信息
     * @param token
     * @return
     */
    @ApiOperation(value = "保存修改教育信息", notes = "保存修改教育信息 ")
    @RequestMapping(value = "/saveUserEducation", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse saveUserEducation(@RequestHeader(required = true, value = "token") String token,
                                          @ApiParam(value = "用户教育信息实体 修改ID 必传", required = true) @RequestBody UserEducation userEducation){

        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            return  UserResponse.creteUserNotExsit();
        }

        userEducation.setUserId(Long.parseLong(userId));

        UserResponse userResponse =  userService.saveUserEducation(userEducation);
        //查找用户基本信息
        User newUser = userService.getUserEntity(userId);
        userResponse.setUser(newUser);
        userResponse.setToken(token);
        return  userResponse;

    }

    /**
     * 保存用户工作经验
     * @param token
     * @param workExperience
     * @return
     */

    @ApiOperation(value = "保存修改工作经验", notes = "保存修改用户工作经验 ")
    @RequestMapping(value = "/saveUserWorkExperience", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse saveUserWorkExperience(@RequestHeader(required = true, value = "token") String token,
                                          @ApiParam(value = "用户工作经验信息实体 修改ID 必传", required = true) @RequestBody UserWorkExperience workExperience){
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            return  UserResponse.creteUserNotExsit();
        }

        workExperience.setUserId(Long.parseLong(userId));

        UserResponse userResponse = userService.saveUserWorkExperience(workExperience);
        //查找用户基本信息
        User newUser = userService.getUserEntity(userId);
        userResponse.setUser(newUser);
        userResponse.setToken(token);

        return  userResponse;
    }


}
