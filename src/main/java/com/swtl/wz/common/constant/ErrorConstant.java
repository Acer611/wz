package com.swtl.wz.common.constant;

/**
 * @program fruit
 * @description: 定义返回返回错误码 和message 的 常量类
 * @author: Gaofei
 * @create: 2018/10/31 09:39
 */

public class ErrorConstant {

    /**
     *
     */
    public static final Integer SUCCESS  = 200;



    /** 没有用户ID  */
    public static final int NOT_USERID = 5001;
    public static final String NOT_USERID_MESSAGE = "没有用户ID,请确认是否登录";

    /** 用户不存在*/
    public static final int NOT_USER = 5002;
    public static final String NOT_USER_MESSAGE = "用户不存在！";

    /** 上传修改头像 文件不存在 */
    public static final int NOT_FACE_FILE = 5003;
    public static final String NOT_FACE_FILE_MESSAGE = "用户头像文件不存在，请检查文件";

    /** 上传文件过大 */
    public static final int FILE_TOO_MAX = 5004;
    public static final String FILE_TOO_MAX_MESSAGE = "上传文件超过系统要求，请上传5M内的文件";


    /** 没有手机号 */
    public static final int NOT_MOBILE = 5005;
    public static final String NOT_MOBILE_MESSAGE = "请检查手机号，手机号为空";


    /** 没有密码 */
    public static final int NOT_PASSWORD = 5006;
    public static final String NOT_PASSWORD_MESSAGE = "请检查密码，密码为空";

    /** 手机号已存在 */
    public static final int MOBILE_HAVE_EXSIT = 5007;
    public static final String MOBILE_HAVE_EXSIT_MESSAGE = "手机号已经被注册";

    /** 生成手机验证码出错 */
    public static final int CHECK_CODE_ERROR = 5008;
    public static final String CHECK_CODE_ERROR_MESSAGE = "发送验证码出错，请联系客服";

    /** 生成手机验证码发送太快 一分钟只允许发送一次 */
    public static final int CHECK_CODE_SEND_TOOFAST_ERROR = 5009;
    public static final String CHECK_CODE_SEND_TOOFAST_ERROR_MESSAGE = "验证码发送台频繁，一分钟内只允许发送一次！";

    /** 当天发送短信验证码超限 */
    public static final int DAY_SEND_CODE_LIMIT_ERROR = 5010;
    public static final String DAY_SEND_CODE_LIMIT_ERROR_MESSAGE = "您当天发送短验证码次数已超限，请明天再来！";

    /** 失效的手机验证码 */
    public static final int CHECK_CODE_INVALID_ERROR = 5011;
    public static final String CHECK_CODE_INVALID_ERROR_MESSAGE = "手机验证码发送已经查过一分钟，已经失效，请重新发送！";

    /** 手机验证码输入有误*/
    public static final int CHECK_CODE_NOT_MATCH_ERROR = 5012;
    public static final String CHECK_CODE_NOT_MATCH_ERROR_MESSAGE = "手机验证码输入有误，请检查短信！";


    /** 手机验证码不能为空*/
    public static final int NOT_INPUT_CHECK_CODE_ERROR = 5013;
    public static final String NOT_INPUT_CHECK_CODE_ERROR_MESSAGE = "手机验证码不能为空！";

    /**
     * Token 生成出错
     */
    public static final Integer TOKEN_CODE  = 4001;
    public static final String TOKEN_MESSAGE = "TOKEN 服务出错";


}
