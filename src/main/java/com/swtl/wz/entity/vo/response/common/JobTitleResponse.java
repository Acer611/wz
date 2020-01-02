package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.common.JobTitle;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 一级职业分类返回对象
 */
public class JobTitleResponse extends CommonResponse {

    /**
     * 一级职业分类实体
     */
    @ApiModelProperty(value = "一级职业信息集合")
    private List<JobTitle> jobTitleList;

    public List<JobTitle> getJobTitleList() {
        return jobTitleList;
    }

    public void setJobTitleList(List<JobTitle> jobTitleList) {
        this.jobTitleList = jobTitleList;
    }
}
