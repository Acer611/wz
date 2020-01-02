package com.swtl.wz.controller.job;

import com.swtl.wz.entity.vo.response.job.CompanyResponse;
import com.swtl.wz.entity.vo.response.job.JobDetailResponse;
import com.swtl.wz.entity.vo.response.job.JobResponse;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import com.swtl.wz.service.job.IJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * 公司和职位信息的处理几口
 */

@Api(tags = "公司职位接口", value = "公司信息和职位信息接口", description = "公司信息和职位信息接口  ")
@RestController
@RequestMapping("/api/job")
public class JobController {


    @Autowired
    private IJobService jobService;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 查询工作职位信息
     *
     * @param token
     * @param cityID
     * @param publishTime
     * @return
     */
    @ApiOperation(value = "查询工作职位信息列表", notes = "查询工作职位信息（包含筛选功能）")
    @RequestMapping(value = "/findJobList", method = RequestMethod.GET)
    @ResponseBody
    public JobResponse findJobList(@RequestHeader(required = false, value = "token") String token,
                                   @ApiParam(value = "市的ID") @RequestParam(required = true) Integer cityID,
                                   @ApiParam(value = "区县的ID  【areaId】 ") @RequestParam(required = false) Integer areaId,
                                   @ApiParam(value = "职位分类 传参为二级分类里的 【classificationId】") @RequestParam(required = false) Integer classificationId,
                                   @ApiParam(value = "工作分类 （简单  躺赚  。。 对应的ID）") @RequestParam(required = false) Integer category,
                                   @ApiParam(value = "发布时间 0 全部  1 当天  2 最近三天 3 最近7天 4 最近一个月") @RequestParam(required = false) Integer publishTime,
                                   @ApiParam(value = "用户的ID  没有传-1") @RequestParam(required = false) Long userId,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize
    ) {
        JobResponse jobResponse = new JobResponse();
        /*String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobResponse.setRetCode(5002);
            jobResponse.setRetMsg("用户不存在！");
            return  jobResponse;
        }*/

        jobResponse = jobService.listJob(userId,cityID,classificationId,category,publishTime, pageNum, pageSize,areaId);

        return jobResponse;

    }

    /**
     * 查询工作职位信息
     *
     * @param token
     * @param cityID
     * @param publishTime
     * @return
     */
    @ApiOperation(value = "查询热门推荐工作职位信息列表", notes = "查询热门推荐工作职位信息列表")
    @RequestMapping(value = "/findHotJobList", method = RequestMethod.GET)
    @ResponseBody
    public JobResponse findHotJobList(@RequestHeader(required = false, value = "token") String token,
                                      @ApiParam(value = "市的ID") @RequestParam(required = true) Integer cityID,
                                      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize
    ) {
        JobResponse jobResponse = new JobResponse();
        /*String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobResponse.setRetCode(5002);
            jobResponse.setRetMsg("用户不存在！");
            return  jobResponse;
        }*/

        jobResponse = jobService.findHotJobList(cityID,pageNum, pageSize);

        return jobResponse;

    }


    @ApiOperation(value = "查询职位的详细信息", notes = "根据职位的详情，查询职位详情")
    @RequestMapping(value = "/detailJobInfo", method = RequestMethod.GET)
    @ResponseBody
    public JobDetailResponse detailJobInfo(@RequestHeader(required = false, value = "token") String token,
                                           @ApiParam(value = "职位的ID") @RequestParam(name = "jobId", required = true ) Long jobId,
                                           @ApiParam(value = "用户的ID  没有传-1") @RequestParam(required = false) Long userId){
        JobDetailResponse JobDetailResponse = new JobDetailResponse();
      /*  String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            JobDetailResponse.setRetCode(5002);
            JobDetailResponse.setRetMsg("用户不存在！");
            return  JobDetailResponse;
        }*/

        JobDetailResponse = jobService.detailJobInfo(userId,jobId);
        return JobDetailResponse;
    }

    /**
     * 查找公司信息根据公司的ID
     * @param token
     * @param companyId
     * @return
     */
    @ApiOperation(value = "查询公司信息", notes = "根据公司ID 查询公司信息")
    @RequestMapping(value = "/findCompanyInfoByID", method = RequestMethod.GET)
    @ResponseBody
    public CompanyResponse findCompanyInfoByID(@RequestHeader(required = false, value = "token") String token,
                                               @ApiParam(value = "公司的ID") @RequestParam(name = "companyId", required = true ) Long companyId){
        CompanyResponse companyResponse = new CompanyResponse();
       /* String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            companyResponse.setRetCode(5002);
            companyResponse.setRetMsg("用户不存在！");
            return  companyResponse;
        }*/
        companyResponse = jobService.findCompanyInfoByID(companyId);
        return  companyResponse;
    }


    /**
     * 用户收藏工作
     * @param token
     * @param jobId
     * @return
     */
    @ApiOperation(value = "用户收藏工作", notes = "用户收藏工作")
    @RequestMapping(value = "/likeJob", method = RequestMethod.GET)
    @ResponseBody
    public JobDetailResponse userLikeJob(@RequestHeader(required = true, value = "token") String token,
                                         @ApiParam(value = "职位的ID") @RequestParam(name = "jobId", required = true ) Long jobId){
        JobDetailResponse jobDetailResponse = new JobDetailResponse();
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobDetailResponse.setRetCode(6001);
            jobDetailResponse.setRetMsg("您还没有登录，请登录后重试!");
            return  jobDetailResponse;
        }
        jobDetailResponse = jobService.addUserLikeJob(Long.parseLong(userId),jobId);
        return  jobDetailResponse;
    }

    /**
     * 用户报名工作
     * @param token
     * @param jobId
     * @return
     */
    @ApiOperation(value = "用户报名工作", notes = "用户报名工作")
    @RequestMapping(value = "/applyJob", method = RequestMethod.GET)
    @ResponseBody
    public JobDetailResponse applyJob(@RequestHeader(required = true, value = "token") String token,
                                      @ApiParam(value = "职位的ID") @RequestParam(name = "jobId", required = true ) Long jobId){
        JobDetailResponse jobDetailResponse = new JobDetailResponse();
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobDetailResponse.setRetCode(6001);
            jobDetailResponse.setRetMsg("您还没有登录，请登录后重试!");
            return  jobDetailResponse;
        }
        jobDetailResponse = jobService.applyJob(Long.parseLong(userId),jobId);
        return  jobDetailResponse;
    }


    /**
     * 获取用户自己收藏的职位信息列表
     * @param token
     * @return
     */

    @ApiOperation(value = "获取用户收藏工作职位列表", notes = "获取用户收藏工作职位列表")
    @RequestMapping(value = "/findUserLikeJobList", method = RequestMethod.GET)
    @ResponseBody
    public JobResponse findUserLikeJobList(@RequestHeader(required = true, value = "token") String token,
                                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                           @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize){
        JobResponse jobResponse = new JobResponse();
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobResponse.setRetCode(6002);
            jobResponse.setRetMsg("您还没有登录，请登录后重试!");
            return  jobResponse;
        }

        jobResponse = jobService.findUserLikeJobList(Long.parseLong(userId), pageNum, pageSize);

        return jobResponse;

    }



    /**
     * 获取用户自己报名的职位信息列表
     * @param token
     * @return
     */

    @ApiOperation(value = "获取用户报名的工作职位列表", notes = "获取用户报名的工作职位列表")
    @RequestMapping(value = "/findUserApplyJobList", method = RequestMethod.GET)
    @ResponseBody
    public JobResponse findUserApplyJobList(@RequestHeader(required = true, value = "token") String token,
                                            @ApiParam(value = "状态 0 已报名  1被查看  2  待面试  3 已录取  4 已拒绝") @RequestParam(name = "status", required = false, defaultValue = "0") int status,
                                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize){
        JobResponse jobResponse = new JobResponse();
        String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId == null){
            jobResponse.setRetCode(6002);
            jobResponse.setRetMsg("用户不存在您还没有登录，请登录后重试!");
            return  jobResponse;
        }

        jobResponse = jobService.findUserApplyJobList(Long.parseLong(userId), status,pageNum, pageSize);

        return jobResponse;

    }

}
