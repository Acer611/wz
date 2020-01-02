package com.swtl.wz.entity.vo.response.user;

import com.swtl.wz.common.constant.ErrorConstant;
import com.swtl.wz.entity.po.user.User;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息返回对象
 */
public class UserResponse  extends CommonResponse {

    @ApiModelProperty(value = "用户对象信息")
    private User user;
    @ApiModelProperty(value = "用户token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {


        if (user.getMobile() == null) {
            user.setMobile("");
        }
        if (user.getPassword() == null) {
            user.setPassword("");
        }

        if (user.getName() == null) {
            user.setName("");
        }
        if (user.getFaceUrl() == null) {
            user.setFaceUrl("");
        }

        if (user.getBalance() == null) {
            user.setBalance(BigDecimal.ZERO);
        }
        if (user.getAddress() == null) {
            user.setAddress("");
        }
        if (user.getSex() == null) {
            user.setSex(3);
        }

        if (user.getEducation() == null) {
            user.setEducation("");
        }
        if (user.getBirthyear() == null) {
            user.setBirthyear("");
        }
        if (user.getBirthday() == null) {
            user.setBirthday("");
        }
        if (user.getIdentity() == null) {
            user.setIdentity(2);
        }
        if (user.getId_card() == null) {
            user.setId_card("");
        }
        if (user.getHeight() == null) {
            user.setHeight(0.0);
        }
        if (user.getWeight() == null) {
            user.setWeight(0.0);
        }
        if (user.getAddress() == null) {
            user.setAddress("");
        }
        if (user.getWechat() == null) {
            user.setWechat("");
        }
        if (user.getQq() == null) {
            user.setQq("");
        }
        if (user.getMail() == null) {
            user.setMail("");
        }
        if (user.getDescrption() == null) {
            user.setDescrption("");
        }
        if (user.getPhoto() == null) {
            user.setPhoto("");
        }
        if (user.getRelaName() == null) {
            user.setRelaName("");
        }
        if (user.getSchedule() == null) {
            user.setSchedule("0");
        }
        if (user.getCreateTime() == null) {
            user.setCreateTime(new Date());
        }
        if (user.getUpdateTime() == null) {
            user.setUpdateTime(new Date());
        }
        this.user = user;
    }

    /**
     * 传参用户ID 有误
     *
     * @return
     */
    public static UserResponse createNotUserIDResponse() {

        class UserNotUserIDResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_USERID;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_USERID_MESSAGE;
            }
        }

        return new UserNotUserIDResponse();
    }

    /**
     * 用户不存在
     */
    public static UserResponse creteUserNotExsit() {
        class UserNotExsitResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_USER;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_USER_MESSAGE;
            }
        }

        return new UserNotExsitResponse();
    }

    /**
     * 上传修改头像文件不存在
     *
     * @return
     */
    public static UserResponse createNotFaceFileResponse() {
        class NotFaceFileResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_FACE_FILE;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_FACE_FILE_MESSAGE;
            }
        }

        return new NotFaceFileResponse();
    }

    /**
     * 上传文件过大
     *
     * @return
     */
    public static UserResponse createFileTooMaxResponse() {
        class FileTooMaxResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.FILE_TOO_MAX;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.FILE_TOO_MAX_MESSAGE;
            }
        }

        return new FileTooMaxResponse();
    }

    /**
     * 没有手机号
     */
    public static UserResponse NotMobileResponse() {
        class NotMobileResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_MOBILE;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_MOBILE_MESSAGE;
            }
        }

        return new NotMobileResponse();
    }

    /**
     * 没有密码
     */
    public static UserResponse NotPassword() {

        class NotPasswordResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_PASSWORD;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_PASSWORD_MESSAGE;
            }
        }

        return new NotPasswordResponse();
    }

    /**
     * 手机号已经存在
     */
    public static UserResponse createMobileHaveExsitResponse() {
        class MobileHaveExsitResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.MOBILE_HAVE_EXSIT;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.MOBILE_HAVE_EXSIT_MESSAGE;
            }
        }
        return new MobileHaveExsitResponse();
    }

    /**
     * 生成手机验证码出错
     *
     * @return
     */
    public static UserResponse generateCodeErrorResponse() {
        class CheckCodeErrorResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.CHECK_CODE_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.CHECK_CODE_ERROR_MESSAGE;
            }
        }
        return new CheckCodeErrorResponse();
    }

    /**
     * 短信验证码发送太快（1分钟内只允许发送一次）
     *
     * @return
     */
    public static UserResponse CodeSendTooFastResponse() {
        class CheckCodeSendTooFirstResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.CHECK_CODE_SEND_TOOFAST_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.CHECK_CODE_SEND_TOOFAST_ERROR_MESSAGE;
            }
        }
        return new CheckCodeSendTooFirstResponse();
    }


    /**
     * 当天短信发送次数插线
     *
     * @return
     */
    public static UserResponse SendCodeDayLimitResponse() {
        class SendCodeDayLimitResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.DAY_SEND_CODE_LIMIT_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.DAY_SEND_CODE_LIMIT_ERROR_MESSAGE;
            }
        }
        return new SendCodeDayLimitResponse();
    }

    /**
     * 手机验证码已经失效
     *
     * @return
     */

    public static UserResponse CheckCodeInvalidResponse() {
        class CheckCodeInvalidResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.CHECK_CODE_INVALID_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.CHECK_CODE_INVALID_ERROR_MESSAGE;
            }
        }
        return new CheckCodeInvalidResponse();
    }

    /**
     * 手机验证码不匹配
     *
     * @return
     */
    public static UserResponse CheckCodeNotMatchResponse() {
        class CheckCodeNotMatchResponse extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.CHECK_CODE_NOT_MATCH_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.CHECK_CODE_NOT_MATCH_ERROR_MESSAGE;
            }
        }
        return new CheckCodeNotMatchResponse();
    }

    /**
     * 没有输入验证码
     *
     * @return
     */
    public static UserResponse NotCheckCode() {
        class NotCheckCode extends UserResponse {

            @Override
            public Integer getRetCode() {
                return ErrorConstant.NOT_INPUT_CHECK_CODE_ERROR;
            }

            @Override
            public String getRetMsg() {
                return ErrorConstant.NOT_INPUT_CHECK_CODE_ERROR_MESSAGE;
            }
        }
        return new NotCheckCode();
    }
}


