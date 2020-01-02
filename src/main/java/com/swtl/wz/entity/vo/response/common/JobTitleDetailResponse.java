package com.swtl.wz.entity.vo.response.common;


import com.swtl.wz.entity.po.common.JobTitleDetail;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 二级职业分类实体
 */
public class JobTitleDetailResponse extends CommonResponse{

    /**
     * 二级职业信息实体集合
     */
    @ApiModelProperty(value = "二级职业信息实体集合")
    private List<JobTitleDetail> jobTitleDetailList;

    public List<JobTitleDetail> getJobTitleDetailList() {
        return jobTitleDetailList;
    }

    public void setJobTitleDetailList(List<JobTitleDetail> jobTitleDetailList) {
        this.jobTitleDetailList = jobTitleDetailList;
    }
}
