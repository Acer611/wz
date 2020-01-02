package com.swtl.wz.common.constant;

/**
 * @program 网赚
 * @description: 常量类
 * @author: Gaofei
 * @create: 2018/11/07 13:54
 */

public class Constant {

    /** 发送验证码的前缀和后缀 */
    public static final String APP_NAME_PREFIX = "【虾米兼职】您的手机验证码是：";
    public static final String APP_NAME_SUFFIX = "。验证码一分钟内有效，如非本人操作请忽略本条短信。";

    /** 每个注册用户Redis key的前缀 */
    public static final String REGISTER_PREFIX = "user:regeister:phone_";
    /**  用户每天发送验证码个数的前缀*/
    public static final String REGISTER_COUNT_PREFIX = "user:regeister:phone_count_";
    /** 允许发送短信验证码的最大次数 */
    public static final Integer MESSAGE_MAX_SEND_TIMES = 20;
    /** 用户个人信息完整度 */
    public static final String USER_INFO_SCHEDULE = "user:schedule:userId_";

}
