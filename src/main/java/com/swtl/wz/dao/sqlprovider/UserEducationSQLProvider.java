package com.swtl.wz.dao.sqlprovider;

import cn.jiguang.common.utils.StringUtils;
import com.swtl.wz.entity.po.user.User;
import com.swtl.wz.entity.po.user.UserEducation;
import com.swtl.wz.entity.po.user.UserWorkExperience;
import org.apache.ibatis.jdbc.SQL;

/**
 * 用户教育信息
 */
public class UserEducationSQLProvider {

    /**
     * 修改用户教育信息
     * @param userEducation
     * @return
     */
    public String updateUserEducation (UserEducation userEducation){
        return new SQL() {{
            {
                UPDATE("t_user_education");
                if(!StringUtils.isEmpty(userEducation.getDomain())){
                    SET("domain = #{domain}");
                }
                if(!StringUtils.isEmpty(userEducation.getEducation())){
                    SET("education=#{education}");
                }
                if(!StringUtils.isEmpty(userEducation.getSchoolName())){
                    SET("schoolName=#{schoolName}");
                }
                if(!StringUtils.isEmpty(userEducation.getExperience())){
                    SET("experience=#{experience}");
                }
                if(userEducation.getStartTime()!=null){
                    SET("startTime=#{startTime}");
                }
                if(userEducation.getEndTime()!=null){
                    SET("endTime=#{endTime}");
                }

                if(userEducation.getCreateTime()!=null){
                    SET("createTime=#{createTime}");
                }
                if(userEducation.getUpdateTime()!=null){
                    SET("updateTime=#{updateTime}");
                }

                WHERE("id=#{id}");
            }
        }}.toString();
    }


    /**
     * 修改用户工作经历信息
     * @param userWorkExperience
     * @return
     */
    public String updateUserWorkExperience (UserWorkExperience userWorkExperience){
        return new SQL() {{
            {
                UPDATE("t_user_workexperience");
                if(!StringUtils.isEmpty(userWorkExperience.getCompany())){
                    SET("company = #{company}");
                }
                if(!StringUtils.isEmpty(userWorkExperience.getTitle())){
                    SET("title=#{title}");
                }
                if(!StringUtils.isEmpty(userWorkExperience.getWorkContent())){
                    SET("workContent=#{workContent}");
                }
                if(!StringUtils.isEmpty(userWorkExperience.getWorkTime())){
                    SET("workTime=#{workTime}");
                }
                if(userWorkExperience.getStartTime()!=null){
                    SET("startTime=#{startTime}");
                }
                if(userWorkExperience.getEndTime()!=null){
                    SET("endTime=#{endTime}");
                }

                if(userWorkExperience.getCreateTime()!=null){
                    SET("createTime=#{createTime}");
                }
                if(userWorkExperience.getUpdatetime()!=null){
                    SET("updatetime=#{updatetime}");
                }

                WHERE("id=#{id}");
            }
        }}.toString();
    }
}
