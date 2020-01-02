package com.swtl.wz.dao.job;


import com.swtl.wz.dao.sqlprovider.JobPositionProvider;
import com.swtl.wz.entity.po.job.CompanyEntity;
import com.swtl.wz.entity.po.job.PositionEntity;
import com.swtl.wz.entity.po.kf.KfDetail;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface JobMapper {
    /**
     * 查询工作职位信息信息
     *
     * @param cityID
     * @param jobTitle
     * @param publishTime
     * @param provinceId
     * @return
     */
    @SelectProvider(type = JobPositionProvider.class, method = "listJob")
    public List<PositionEntity> listJob(@Param("cityID") Integer cityID, @Param("classificationId") Integer classificationId,
                                        @Param("category") Integer category, @Param("publishTime") Integer publishTime, @Param("areaId")Integer areaId);

    /**
     * 查询职位详细信息
     *
     * @param jobId
     * @return
     */
    @Select("SELECT " +
            " c.city AS locationName," +
            " t.company AS companyName, t.authentication AS authentication, " +
            " job.id, " +
            " job.companyId, " +
            " job.kfId, " +
            " job.title, " +
            " job.type, " +
            " job.cleanType, " +
            " job.needPeople, " +
            " job.hasPeople, " +
            " job.reportPeople, " +
            " job.money, " +
            " job.jobRequired, " +
            " job.taskType, " +
            " job.workflow, " +
            " job.jobDetail, " +
            " job.address, " +
            " job.location, " +
            " job.lable, " +
            " job.category, " +
            " job.publishTime, " +
            " job.createTime, " +
            " job.updateTime " +
            " FROM " +
            " job_position job " +
            " LEFT OUTER JOIN city c ON job.location = c.cid " +
            " LEFT JOIN t_company t ON t.companyId= job.companyId " +
            " WHERE " +
            " job.id = #{jobId}")
    PositionEntity detailJobInfo(Long jobId);

    /**
     * 查询公司的详细信息
     *
     * @param companyId
     * @return
     */
    @Select(" SELECT id,company,description,authentication,domain,type,`status`,registeredCapital,registerDate," +
            " address,registrationAuthority,creditCode, groupCode,businessScop,createTime,updateTime " +
            " FROM t_company where companyId=#{companyId}")
    CompanyEntity findCompanyInfoByID(Long companyId);


    /**
     * 保存用户喜欢的职业
     *
     * @param userId
     * @param jobId
     * @param createTime
     */
    @Insert("insert into t_user_like_job(userId,positId,createTime) values(#{userId},#{jobId},#{createTime})")
    void saveUserLikeJob(@Param("userId") long userId, @Param("jobId") Long jobId, @Param("createTime") Date createTime);

    /**
     * 保存用户报名的职位
     *
     * @param userId
     * @param jobId
     * @param status
     * @param createTimee
     */
    @Insert("insert into t_user_position(userId,positId,status,createTime,updateTime) values(#{userId},#{jobId},#{status},#{createTime},#{createTime})")
    void applyJob(@Param("userId") long userId, @Param("jobId") Long jobId, @Param("status") Integer status, @Param("createTime") Date createTimee);

    /**
     * 查找用户收藏的工作职位列表
     *
     * @param userId
     * @return
     */
    @Select("SELECT c.city as locationName,job.id,job.companyId,job.kfId,job.title,job.type,job.cleanType,job.needPeople,job.hasPeople,job.reportPeople,\n" +
            " job.money,job.jobRequired,job.taskType,job.workflow,job.jobDetail,job.address,job.location,job.lable,job.category,job.publishTime,\n" +
            " job.createTime,job.updateTime FROM job_position job LEFT OUTER JOIN city c ON job.location=c.cid \n" +
            " LEFT JOIN t_user_like_job u ON u.positId = job.id where u.userId=#{userId}")
    List<PositionEntity> findUserLikeJobList(long userId);

    /**
     * 查找用户已经报名的工作职位列表
     *
     * @param userId
     * @return
     */
    @Select("SELECT c.city as locationName,job.id,job.companyId,job.kfId,job.title,job.type,job.cleanType,job.needPeople,job.hasPeople,job.reportPeople,\n" +
            " job.money,job.jobRequired,job.taskType,job.workflow,job.jobDetail,job.address,job.location,job.lable,job.category,job.publishTime,\n" +
            " job.createTime,job.updateTime FROM job_position job LEFT OUTER JOIN city c ON job.location=c.cid \n" +
            " LEFT JOIN t_user_position u ON u.positId = job.id where u.userId=#{userId} and  u.status=#{status}")
    List<PositionEntity> findUserApplyJobList(@Param("userId")long userId, @Param("status")Integer status);


    /**
     * 根据用户ID 和工作职位Id查找报名信息
     * @param userId
     * @param jobId
     * @return
     */
    @Select("SELECT id from t_user_like_job where userId=#{userId} and positId = #{jobId}")
    Integer findUserLikeByUserIdJobId(@Param("userId") long userId, @Param("jobId") Long jobId);

    /**
     *根据用户ID 和工作职位查找用户报名信息
     * @param userId
     * @param jobId
     * @return
     */
    @Select("SELECT id from t_user_position where userId=#{userId} and positId = #{jobId}")
    Integer findApplyStatusByUserIdJobId(@Param("userId") long userId, @Param("jobId") Long jobId);

    /**
     * 更新报名人数
     * @param jobId
     */
    @Select("UPDATE job_position set reportPeople=reportPeople+1 WHERE id=#{jobId} ")
    void pulsReportNumber(Long jobId);


    /**
     * 删除收藏信息
     */
    @Delete(" DELETE from t_user_like_job where id=#{id}")
    void deleteByUserIdJobID(Integer id);

    /**
     * 查询热门职位列表
     * @return
     */
    @Select("SELECT c.city as locationName,job.id,companyId,kfId,IFNULL(title,'')title,IFNULL(type,'')type,IFNULL(cleanType,'')cleanType," +
            " IFNULL(needPeople,0)needPeople,IFNULL(hasPeople,0)hasPeople,IFNULL(reportPeople,0)reportPeople," +
            " IFNULL(money,0) money,IFNULL(jobRequired,'')jobRequired,taskType," +
            " IFNULL(workflow,'')workflow,IFNULL(jobDetail,'')jobDetail,IFNULL(address,'')address,location,lable,category,publishTime,IFNULL(isHot,'')isHOT," +
            " createTime,updateTime FROM job_position job LEFT OUTER JOIN city c ON job.location=c.cid where 1=1 and job.location=#{cityId}")
    List<PositionEntity> listHotJob(Integer cityId);

    /**
     * 查询客服详情
     * @param kfId
     * @return
     */
    @Select("SELECT * from t_kf_detail where id=#{kfId}")
    KfDetail findKfDetail(Long kfId);

    /**
     * 根据用户id 和职位信息查询是否报名
     * @param userId
     * @param jobId
     * @return
     */
    @Select("SELECT id from t_user_position where userId=#{userId} and positId=#{jobId}")
    Long findUserApplyStatus(@Param("userId") long userId, @Param("jobId")Long jobId);
}
