package com.swtl.wz.controller.user;

import com.github.pagehelper.util.StringUtil;
import com.swtl.wz.common.utils.HttpServletUtil;
import com.swtl.wz.entity.po.user.UserRegesiterRequset;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import com.swtl.wz.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户登录注册接口
 */
@Api(tags = "注册登录接口",value = "用户登录注册接口",description = "登录注册接口， 包含用户登录注册 发送验证等接口  ")
@RestController
public class AuthController {


    @Autowired
    private IUserService userService;
    /**
     * 心跳检测
     *
     * @return
     */
    @ApiOperation(value = "心跳接口")
    @ResponseBody
    @RequestMapping(value = "/hit", method = RequestMethod.GET)
    public String hit() {

        return "ok";
    }


    /**
     * 用户注册
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "新用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public UserResponse register(@RequestHeader(required = true, value = "channel") String channel,
                                 @RequestBody UserRegesiterRequset userRegesiterRequset){

        //检验手机号
        if(userRegesiterRequset.getMobile()==null||"".equalsIgnoreCase(userRegesiterRequset.getMobile())){
            return UserResponse.NotMobileResponse();
        }
        //检验密码
        if(userRegesiterRequset.getPassword()==null||"".equalsIgnoreCase(userRegesiterRequset.getPassword())){
            return UserResponse.NotPassword();
        }

        //检验验证码
        if(userRegesiterRequset.getCheckCode()==null||"".equalsIgnoreCase(userRegesiterRequset.getCheckCode())){
            return  UserResponse.NotCheckCode();
        }

        UserResponse userResponse = userService.register(userRegesiterRequset,channel);
        return userResponse;
    }

    @ApiOperation(value = "发送手机短信验证码")
    @ResponseBody
    @RequestMapping(value = "/sendCode", method = RequestMethod.GET)
    public UserResponse sendCode(@ApiParam(value = "手机号")  @RequestParam(required = true)String phone,HttpServletRequest request) {

        if(StringUtil.isEmpty(phone)){
            return UserResponse.NotMobileResponse();
        }
        //获取IP 地址
        String IP = HttpServletUtil.getRealRemoteAddr(request);

        UserResponse userResponse = userService.sendCode(phone,IP);
        return  userResponse;
    }


    /**
     * 用户登录
     *
     * @return
     */
    @ApiOperation(value = "用户登录")
    @ResponseBody
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public UserResponse userLogin(@RequestBody UserRegesiterRequset userRegesiterRequset) {

        //检验手机号
        if(userRegesiterRequset.getMobile()==null||"".equalsIgnoreCase(userRegesiterRequset.getMobile())){
            return UserResponse.NotMobileResponse();
        }
        //检验密码
        if(userRegesiterRequset.getPassword()==null||"".equalsIgnoreCase(userRegesiterRequset.getPassword())){
            return UserResponse.NotPassword();
        }


        UserResponse userResponse = userService.login(userRegesiterRequset);
        return userResponse;
    }



    /**
     * 用户登出
     *
     * @return
     */
    @ApiOperation(value = "用户登出")
    @ResponseBody
    @RequestMapping(value = "/userLoginOut", method = RequestMethod.GET)
    public UserResponse userLoginOut(@RequestParam(name = "userId") String userId) {

        if (userId==null){
            return  UserResponse.createNotUserIDResponse();
        }
        UserResponse userResponse = userService.loginOut(userId);

        return userResponse;
    }


    /**
     * 修改用户密码
     * @param userRegesiterRequset
     * @return
     */
    @ApiOperation(value = "修改密码" ,notes = "用户忘记密码后，可通过手机号验证码的方式，重新设置新的密码。")
    @ResponseBody
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public UserResponse resetPassword(@RequestBody UserRegesiterRequset userRegesiterRequset) {

        //检验手机号
        if(userRegesiterRequset.getMobile()==null||"".equalsIgnoreCase(userRegesiterRequset.getMobile())){
            return UserResponse.NotMobileResponse();
        }
        //检验密码
        if(userRegesiterRequset.getPassword()==null||"".equalsIgnoreCase(userRegesiterRequset.getPassword())){
            return UserResponse.NotPassword();
        }
        //检验验证码
        if(userRegesiterRequset.getCheckCode()==null||"".equalsIgnoreCase(userRegesiterRequset.getCheckCode())){
            return  UserResponse.NotCheckCode();
        }
        UserResponse userResponse = userService.resetPassword(userRegesiterRequset);
        return userResponse;
    }



}
