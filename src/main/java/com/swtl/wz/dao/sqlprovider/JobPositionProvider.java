package com.swtl.wz.dao.sqlprovider;

import org.apache.ibatis.annotations.Param;

/**
 * 职位SQL 信息
 */
public class JobPositionProvider {

    /**
     * 获取职位信息
     *
     * @param cityID
     * @param jobTitle
     * @return
     */
    public String listJob(@Param("cityID") Integer cityID,@Param("classificationId") Integer classificationId,
                          @Param("category")Integer category, @Param("publishTime") Integer publishTime,@Param("areaId")Integer areaId) {

        String sql = "SELECT c.city as locationName,job.id,companyId,kfId,IFNULL(title,'')title,IFNULL(type,'')type,IFNULL(cleanType,'')cleanType," +
                " IFNULL(needPeople,0)needPeople,IFNULL(hasPeople,0)hasPeople,IFNULL(reportPeople,0)reportPeople," +
                " IFNULL(money,0) money,IFNULL(jobRequired,'')jobRequired,taskType," +
                " IFNULL(workflow,'')workflow,IFNULL(jobDetail,'')jobDetail,IFNULL(address,'')address,location,lable,category,publishTime," +
                " createTime,updateTime, IFNULL(isHot,0)isHot FROM job_position job LEFT OUTER JOIN city c ON job.location=c.cid where 1=1";

        if (areaId != null && areaId > 0) {
            String proSql = " AND areaId ='" + areaId +"' ";
            sql = sql + proSql;
        }

        if (cityID != null && cityID > 0) {
           String citySql = " AND location ='" + cityID +"' ";
           sql = sql + citySql;
        }

        if (classificationId != null && classificationId > 0) {
            String jobTitleSql = " AND taskType = '" + classificationId +"' ";
            sql = sql + jobTitleSql;
        }
        if (category != null && category > 0) {
            String categorySQL = " AND category = '" + category +"' ";
            sql = sql + categorySQL;
        }
        if (publishTime != null && publishTime > 0) {
            String publishTimeSQL = "";
            //0 全部 1 当天 2 最近三天 3 最近7天 4 最近一个月
            if(publishTime==1){
                 publishTimeSQL = " AND TO_DAYS(publishTime) = TO_DAYS(now()) ";
                 sql = sql + publishTimeSQL;
            }

            if(publishTime==2){
                publishTimeSQL = " AND DATE_SUB(CURDATE(), INTERVAL 3 DAY) <= date(publishTime) ";
                sql = sql + publishTimeSQL;
            }

            if(publishTime==3){
                publishTimeSQL = " AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(publishTime) ";
                sql = sql + publishTimeSQL;
            }

            if(publishTime==4){
                publishTimeSQL = " AND DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(publishTime) ";
                sql = sql + publishTimeSQL;
            }

        }


        String orderSQL = " order by publishTime DESC ";
        sql = sql + orderSQL;
        return sql;
    }
}
