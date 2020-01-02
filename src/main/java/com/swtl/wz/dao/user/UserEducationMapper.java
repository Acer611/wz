package com.swtl.wz.dao.user;

import com.swtl.wz.dao.sqlprovider.UserEducationSQLProvider;
import com.swtl.wz.entity.po.user.User;
import com.swtl.wz.entity.po.user.UserEducation;
import com.swtl.wz.entity.po.user.UserWorkExperience;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户的教育和工作经历信息查询
 */
@Mapper
public interface UserEducationMapper {

    /**
     * 保存用户的教育信息
     * @param userEducation
     */

    @Insert(" insert into `t_user_education`(userId,schoolName,`domain`,education,startTime,endTime,experience,createTime,updateTime)  " +
            " values(#{userId},#{schoolName},#{domain},#{education},#{startTime},#{endTime},#{experience},#{createTime},#{updateTime} )")
    void saveUserEducation(UserEducation userEducation);

    /**
     * 修改教育信息
     * @param userEducation
     */
    @UpdateProvider(type= UserEducationSQLProvider.class, method="updateUserEducation")
    void updateUserEducation(UserEducation userEducation);

    /**
     * 查询用户的教育信息
     * @param userId
     * @return
     */
    @Select("SELECT id,userId,schoolName,`domain`,education,startTime,endTime,experience,createTime,updateTime from t_user_education where userId=#{userId} ")
    List<UserEducation> findUserEducationByUserId(Long userId);

    /**
     * 修改工作经历
     * @param workExperience
     */
    @UpdateProvider(type= UserEducationSQLProvider.class, method="updateUserWorkExperience")
    void updateUserWorkExperience(UserWorkExperience workExperience);

    /**
     * 保存用户工作经历
     * @param workExperience
     */
    @Insert(" insert into `t_user_workexperience`(userId,title,`startTime`,endTime,company,workTime,workContent,createTime,updatetime)  " +
            " values(#{userId},#{title},#{startTime},#{endTime},#{company},#{workTime},#{workContent},#{createTime},#{updatetime} )")
    void saveUserWorkExperience(UserWorkExperience workExperience);

    /**
     * 查询用户的工作经历
     * @param userId
     * @return
     */
    @Select("SELECT id,userId,title,`startTime`,endTime,company,workTime,workContent,createTime,updatetime from t_user_workexperience where userId=#{userId}")
    List<UserWorkExperience> findUserWorkExperience(Long userId);
}
