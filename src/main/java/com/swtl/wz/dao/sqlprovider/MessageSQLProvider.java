package com.swtl.wz.dao.sqlprovider;

import org.apache.ibatis.annotations.Param;

public class MessageSQLProvider {


    /**
     * 获取所有职位信息
     *
     * @param userId
     * @param status
     * @return
     */

    public String listAll(@Param("userId") Long userId, @Param("status")Integer status) {

        String sql = "SELECT id,type,ifnull(title,'')AS title,IFNULL(content,'')AS content,IFNULL(`status`, 0) AS `status`, IFNULL(`createTime`, NOW()) AS `createTime`," +
                    "IFNULL(userId,0) AS userId  FROM t_message WHERE 1=1 ";


        if(status==0){
            String statusSQL = " AND status = 0 ";
            sql = sql + statusSQL;
        }

        if(status==1){
            String statusSQL = " AND status = 1 ";
            sql = sql + statusSQL;
        }

        if(userId!=null&&userId>0){
            String userIdSQL = " AND (userid=#{userId} or userId =0) " ;
            sql = sql + userIdSQL;
        }

        if(userId==-1){
            String userIdSQL = " AND  userId =0 " ;
            sql = sql + userIdSQL;
        }

        String orderSQL = " ORDER BY createTime DESC";
        sql = sql + orderSQL;

        return  sql;

    }
}
