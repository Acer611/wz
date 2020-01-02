package com.swtl.wz.dao.sqlprovider;

import cn.jiguang.common.utils.StringUtils;
import com.swtl.wz.entity.po.user.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSQLProvider {


    /**
     * 修改用户基本信息
     * @param user
     * @return
     */
    public String updateUser (User user){
        return new SQL() {{
            {
                UPDATE("t_user");

                if(!StringUtils.isEmpty(user.getPassword())){
                    SET("password=#{password}");
                }
                if(!StringUtils.isEmpty(user.getName())){
                    SET("name=#{name}");
                }
                if(!StringUtils.isEmpty(user.getFaceUrl())){
                    SET("faceUrl=#{faceUrl}");
                }

                if(user.getSex()!=null){
                    SET("sex=#{sex}");
                }
                if(!StringUtils.isEmpty(user.getEducation())){
                    SET("education=#{education}");
                }
                if(!StringUtils.isEmpty(user.getBirthyear())){
                    SET("birthyear=#{birthyear}");
                }
                if(!StringUtils.isEmpty(user.getBirthday())){
                    SET("birthday=#{birthday}");
                }
                if(user.getIdentity()!=null){
                    SET("identity=#{identity}");
                }
                if(user.getHeight()!=null){
                    SET("height=#{height}");
                }
                if(user.getWeight()!=null){
                    SET("weight=#{weight}");
                }
                if(!StringUtils.isEmpty(user.getAddress())){
                    SET("address=#{address}");
                }
                if(!StringUtils.isEmpty(user.getWechat())){
                    SET("wechat=#{wechat}");
                }
                if(!StringUtils.isEmpty(user.getQq())){
                    SET("qq=#{qq}");
                }
                if(!StringUtils.isEmpty(user.getMail())){
                    SET("mail=#{mail}");
                }
                if(!StringUtils.isEmpty(user.getDescrption())){
                    SET("descrption=#{descrption}");
                }
                if(!StringUtils.isEmpty(user.getPhoto())){
                    SET("photo=#{photo}");
                }
                if(!StringUtils.isEmpty(user.getRelaName())){
                    SET("relaName=#{relaName}");
                }
                if(!StringUtils.isEmpty(user.getId_card())){
                    SET("id_card=#{id_card}");
                }
                if(!StringUtils.isEmpty(user.getSchedule())){
                    SET("schedule=#{schedule}");
                }
                if(user.getCreateTime()!=null){
                    SET("createTime=#{createTime}");
                }
                if(user.getUpdateTime()!=null){
                    SET("updateTime=#{updateTime}");
                }
                if(user.getIsHealth()!=null){
                    SET("isHealth=#{isHealth}");
                }

                WHERE("id=#{id}");
            }
        }}.toString();
    }
}
