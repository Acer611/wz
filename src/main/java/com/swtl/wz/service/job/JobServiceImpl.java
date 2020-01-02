package com.swtl.wz.service.job;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swtl.wz.dao.job.JobMapper;
import com.swtl.wz.entity.po.job.CompanyEntity;
import com.swtl.wz.entity.po.job.PositionEntity;
import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.vo.response.job.CompanyResponse;
import com.swtl.wz.entity.vo.response.job.JobDetailResponse;
import com.swtl.wz.entity.vo.response.job.JobResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 工作职位业务处理层
 */
@Service(value = "jobService")
public class JobServiceImpl implements IJobService {


    @Autowired
    private JobMapper jobMapper;

    /**
     * 查找工作职位信息列表
     * @param userId
     * @param cityID
     * @param jobTitle
     * @param publishTime
     * @param provinceId
     * @return
     */
    @Override
    public JobResponse listJob(Long userId, Integer cityID, Integer classificationId, Integer categoty, Integer publishTime, int pageNum, int pageSize, Integer areaId) {

        JobResponse jobResponse = new JobResponse();

        //TODO  收藏  报名 等展示
        PageHelper.startPage(pageNum, pageSize);
        List<PositionEntity> positionEntityList = jobMapper.listJob(cityID,classificationId,categoty,publishTime,areaId);
        PageInfo result = new PageInfo(positionEntityList);
        jobResponse.setPageInfo(result);

        return jobResponse;
    }

    /**
     * 查询职位详情信息
     * @param userId
     * @param jobId
     * @return
     */
    @Override
    public JobDetailResponse detailJobInfo(long userId, Long jobId) {

        JobDetailResponse jobDetailResponse = new JobDetailResponse();

        // 收藏  报名 等展示
        PositionEntity positionEntity = jobMapper.detailJobInfo(jobId);
        //收藏状态
        Integer  id = jobMapper.findUserLikeByUserIdJobId(userId,jobId);
        if(id!=null&&id>0){
            positionEntity.setLikeStatus(1);
        }

        //报名状态
        Integer applyId = jobMapper.findApplyStatusByUserIdJobId(userId,jobId);
        if(applyId!=null&&applyId>0){
            positionEntity.setApplyStatus(1);
        }

        if(positionEntity.getKfId()!=null){
            //获取客服详细信息
            KfDetail kfDetail = jobMapper.findKfDetail(positionEntity.getKfId());
            if(kfDetail!=null){
                jobDetailResponse.setKfDetail(kfDetail);
            }

        }else{
            jobDetailResponse.setKfDetail(new KfDetail());
        }

        jobDetailResponse.setPositionEntity(positionEntity);
        return jobDetailResponse;
    }

    /**
     * 查询公司的全部信息
     * @param companyId
     * @return
     */
    @Override
    public CompanyResponse findCompanyInfoByID(Long companyId) {
        CompanyResponse companyResponse = new CompanyResponse();
        CompanyEntity companyEntity = jobMapper.findCompanyInfoByID(companyId);

        companyResponse.setCompanyEntity(companyEntity);
        return companyResponse;
    }

    /**
     * 用户添加自己喜欢的工作
     * @param userID
     * @param jobId
     * @return
     */
    @Override
    public JobDetailResponse addUserLikeJob(long userID, Long jobId) {

        Integer id = jobMapper.findUserLikeByUserIdJobId(userID,jobId);
        //取消收藏
        if(null!=id){
            jobMapper.deleteByUserIdJobID(id);
        }else{
            //保存用户喜欢的工作
            jobMapper.saveUserLikeJob(userID,jobId,new Date());
        }

        return new JobDetailResponse();
    }

    /**
     * 用户报名某一个工作
     * @param userId
     * @param jobId
     * @return
     */
    @Override
    public JobDetailResponse applyJob(long userId, Long jobId) {
        JobDetailResponse jobDetailResponse = new JobDetailResponse();
         Long id = jobMapper.findUserApplyStatus(userId,jobId);
         if(id!=null){
             jobDetailResponse.setRetCode(60010);
             jobDetailResponse.setRetMsg("您已经报名过当前职位了！");
             return  jobDetailResponse;
         }
        //保存用户报名的工作
        jobMapper.applyJob(userId,jobId, 0,new Date());
        //更新当前工作报名的人数
        jobMapper.pulsReportNumber(jobId);
        return new JobDetailResponse();
    }


    /**
     * 查找用户收藏的工作的列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public JobResponse findUserLikeJobList(long userId, int pageNum, int pageSize) {
        JobResponse jobResponse = new JobResponse();
        PageHelper.startPage(pageNum, pageSize);

        List<PositionEntity> positionEntityList = jobMapper.findUserLikeJobList(userId);
        PageInfo result = new PageInfo(positionEntityList);

        jobResponse.setPageInfo(result);

        return jobResponse;
    }

    /**
     * 查询用户已报名职位信息列表
     * @param userId
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public JobResponse findUserApplyJobList(long userId, int status, int pageNum, int pageSize) {
        JobResponse jobResponse = new JobResponse();
        PageHelper.startPage(pageNum, pageSize);

        List<PositionEntity> positionEntityList = jobMapper.findUserApplyJobList(userId,status);
        PageInfo result = new PageInfo(positionEntityList);

        jobResponse.setPageInfo(result);

        return jobResponse;
    }

    /**
     * 查询热门推荐职位信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public JobResponse findHotJobList(Integer cityID,int pageNum, int pageSize) {
        JobResponse jobResponse = new JobResponse();

        PageHelper.startPage(pageNum, pageSize);
        List<PositionEntity> positionEntityList = jobMapper.listHotJob(cityID);
        PageInfo result = new PageInfo(positionEntityList);
        jobResponse.setPageInfo(result);
        return jobResponse;
    }
}
