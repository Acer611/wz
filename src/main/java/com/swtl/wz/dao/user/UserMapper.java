package com.swtl.wz.dao.user;


import com.swtl.wz.dao.sqlprovider.UserSQLProvider;
import com.swtl.wz.entity.po.user.CheckCode;
import com.swtl.wz.entity.po.user.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * 用户数据层操作接口
 */
@Mapper
public interface UserMapper {
    /**
     * 查找用户基本信息
     * @param userId
     * @return
     */
    @Select("select * from t_user where id = #{userId}")
    @Results({
            @Result(id = true,column="id",property="id"),
            @Result(column="mobile",property="mobile"),
            @Result(column="password",property="password"),
            @Result(column="faceUrl",property="faceUrl"),
            @Result(column="balance",property="balance"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="education",property="education"),
            @Result(column="birthyear",property="birthyear"),
            @Result(column="birthday",property="birthday"),
            @Result(column="identity",property="identity"),
            @Result(column="height",property="height"),
            @Result(column="weight",property="weight"),
            @Result(column="address",property="address"),
            @Result(column="wechat",property="wechat"),
            @Result(column="qq",property="qq"),
            @Result(column="mail",property="mail"),
            @Result(column="descrption",property="descrption"),
            @Result(column="photo",property="photo"),
            @Result(column="relaName",property="relaName"),
            @Result(column="id_card",property="id_card"),
            @Result(column="schedule",property="schedule"),
            @Result(column="createTime",property="createTime"),
            @Result(column="updateTime",property="updateTime"),
            @Result(column="isHealth",property="isHealth"),
            @Result(column="id",property="userEducationList",
                    many=@Many(
                            select="com.swtl.wz.dao.user.UserEducationMapper.findUserEducationByUserId",
                            fetchType= FetchType.EAGER
                    )
            ),
            @Result(column="id",property="userWorkExperienceList",
            many=@Many(
                    select="com.swtl.wz.dao.user.UserEducationMapper.findUserWorkExperience",
                    fetchType= FetchType.EAGER
            ))

    })
    User selectUserByID(Long userId);

    /**
     * 修改用户基本信息
     * @param user
     */
    @UpdateProvider(type= UserSQLProvider.class, method="updateUser")
    void updateUser(User user);

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @Insert(" insert into `t_user`(mobile,`password`,`name`,createTime,updateTime,channel)  " +
            " values(#{mobile},#{password},#{name},#{createTime},#{updateTime} ,#{channel})")
    void insertUser(User user);

    /**
     *根据手机号查找用户信息
     * @param mobile
     * @return
     */
    @Select("select * from t_user where mobile = #{mobile}")
    @Results({
            @Result(id = true,column="id",property="id"),
            @Result(column="mobile",property="mobile"),
            @Result(column="password",property="password"),
            @Result(column="faceUrl",property="faceUrl"),
            @Result(column="balance",property="balance"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="education",property="education"),
            @Result(column="birthyear",property="birthyear"),
            @Result(column="birthday",property="birthday"),
            @Result(column="identity",property="identity"),
            @Result(column="height",property="height"),
            @Result(column="weight",property="weight"),
            @Result(column="address",property="address"),
            @Result(column="wechat",property="wechat"),
            @Result(column="qq",property="qq"),
            @Result(column="mail",property="mail"),
            @Result(column="descrption",property="descrption"),
            @Result(column="photo",property="photo"),
            @Result(column="relaName",property="relaName"),
            @Result(column="id_card",property="id_card"),
            @Result(column="schedule",property="schedule"),
            @Result(column="createTime",property="createTime"),
            @Result(column="updateTime",property="updateTime"),
            @Result(column="isHealth",property="isHealth"),
            @Result(column="id",property="userEducationList",
                    many=@Many(
                            select="com.swtl.wz.dao.user.UserEducationMapper.findUserEducationByUserId",
                            fetchType= FetchType.EAGER
                    )
            ),
            @Result(column="id",property="userWorkExperienceList",
                    many=@Many(
                            select="com.swtl.wz.dao.user.UserEducationMapper.findUserWorkExperience",
                            fetchType= FetchType.EAGER
                    ))

    })
    User findUserByPhone(String mobile);

    /**
     * 保存短信验证码信息（check_code 表）
     * @param checkCode
     */
    @Insert("insert into check_code(id,ip,msg_id,phone, check_code,create_at,expire_at,is_use,use_at,del_flag) " +
            " values(#{id},#{ip},#{msgId},#{phone},#{checkCode},#{createAt},#{expireAt},#{isUse},#{useAt},#{delFlag}" +
            ")" )
    void saveCheckCode(CheckCode checkCode);

    /**
     * 根据手机号查询验证码信息
     * @param phone
     * @return
     */
    @Select("SELECT id,ip,msg_id,phone,check_code,create_at,expire_at,is_use,use_at,del_flag FROM check_code WHERE phone =#{phone};")
    @Results(value ={
            @Result(id=true, property="id",column="id"),
            @Result(property="ip",column="ip"),
            @Result(property="phone",column="phone"),
            @Result(property="checkCode",column="check_code"),
            @Result(property="createAt",column="create_at"),
            @Result(property="expireAt",column="expire_at"),
            @Result(property="isUse",column="is_use"),
            @Result(property="useAt",column="use_at"),
            @Result(property="delFlag",column="del_flag"),
            @Result(property="msgId",column="msg_id")
    })
    CheckCode findCheckCodeBYPhone(String phone);

    /**
     * 删除数据信息
     * @param phone
     */
    @Delete(" DELETE FROM check_code WHERE phone =#{phone}")
    void deleteCheckCodeByPhone(String phone);

    /**
     * 根据手机号和密码查询用户信息
     * @param mobile
     * @param password
     * @return
     */
    @Select("select * from t_user where mobile = #{mobile} and password=#{password}")
    @Results({
            @Result(id = true,column="id",property="id"),
            @Result(column="mobile",property="mobile"),
            @Result(column="password",property="password"),
            @Result(column="faceUrl",property="faceUrl"),
            @Result(column="balance",property="balance"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="education",property="education"),
            @Result(column="birthyear",property="birthyear"),
            @Result(column="birthday",property="birthday"),
            @Result(column="identity",property="identity"),
            @Result(column="height",property="height"),
            @Result(column="weight",property="weight"),
            @Result(column="address",property="address"),
            @Result(column="wechat",property="wechat"),
            @Result(column="qq",property="qq"),
            @Result(column="mail",property="mail"),
            @Result(column="descrption",property="descrption"),
            @Result(column="photo",property="photo"),
            @Result(column="relaName",property="relaName"),
            @Result(column="id_card",property="id_card"),
            @Result(column="schedule",property="schedule"),
            @Result(column="createTime",property="createTime"),
            @Result(column="updateTime",property="updateTime"),
            @Result(column="isHealth",property="isHealth"),
            @Result(column="id",property="userEducationList",
                    many=@Many(
                            select="com.swtl.wz.dao.user.UserEducationMapper.findUserEducationByUserId",
                            fetchType= FetchType.EAGER
                    )
            ),
            @Result(column="id",property="userWorkExperienceList",
                    many=@Many(
                            select="com.swtl.wz.dao.user.UserEducationMapper.findUserWorkExperience",
                            fetchType= FetchType.EAGER
                    ))

    })
    User finUserByPhonePass(@Param("mobile") String mobile, @Param("password")String password);

    /**
     * 修改密码
     * @param mobile
     * @param password
     */
    @Update("update t_user set password=#{password} where mobile =#{mobile}")
    void updateUserPassword(@Param("mobile")String mobile, @Param("password")String password);

    /**
     * 查找最大的用户ID
     * @return
     */
    @Select("SELECT MAX(id) from t_user")
    Long finMaxID();

    /**
     * 查询用户的信息（简历完整度使用）
     * @param userId
     * @return
     */
    @Select("SELECT id,faceUrl,`name`,sex,education,birthyear,birthday,identity,height,weight,address,wechat,qq,mail,descrption,photo,relaName,id_card FROM t_user WHERE id =#{userId}")
    User finUserInfoByID(long userId);
}
