package com.swtl.wz.entity.po.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 注册传参实体
 */
@Data
public class UserRegesiterRequset {

    @ApiModelProperty(value="手机号")
    private String mobile;
    @ApiModelProperty(value="密码")
    private String password;
    @ApiModelProperty(value="验证码")
    private String checkCode;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
