package com.swtl.wz.service.job;

import com.swtl.wz.entity.vo.response.job.CompanyResponse;
import com.swtl.wz.entity.vo.response.job.JobDetailResponse;
import com.swtl.wz.entity.vo.response.job.JobResponse;

/**
 * 工作职位Service 层接口
 */
public interface IJobService {

    /**
     * 查找工作职位信息列表
     *
     * @param userId
     * @param cityID
     * @param jobTitle
     * @param publishTime
     * @param provinceId
     * @return
     */
    JobResponse listJob(Long userId, Integer cityID, Integer jobTitle, Integer categoru, Integer publishTime, int pageNum, int pageSize, Integer provinceId);


    /**
     *查询工作职位详情
     * @param userId
     * @param jobId
     * @return
     */
    JobDetailResponse detailJobInfo(long userId, Long jobId);

    /**
     * 根据公司的id 查询公司的详细信息
     * @param companyId
     * @return
     */
    CompanyResponse findCompanyInfoByID(Long companyId);

    /**
     * 用户添加职业自己喜欢的工作
     * @param userId
     * @param jobId
     * @return
     */
    JobDetailResponse addUserLikeJob(long userId, Long jobId);

    /**
     * 用户报名某一个工作
     * @param userId
     * @param jobId
     * @return
     */
    JobDetailResponse applyJob(long userId, Long jobId);

    /**
     * 查找用户收藏的工作的列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    JobResponse findUserLikeJobList(long userId, int pageNum, int pageSize);

    /**
     * 查询用户报名工组信息雷彪
     * @param userId
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    JobResponse findUserApplyJobList(long userId, int status, int pageNum, int pageSize);

    /**
     * 查询热门推荐工作职位列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    JobResponse findHotJobList(Integer cityID,int pageNum, int pageSize);
}
