package com.swtl.wz.entity.vo.response.job;


import com.github.pagehelper.PageInfo;
import com.swtl.wz.entity.po.job.PositionEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 职位信息返回对象
 */
public class JobResponse extends CommonResponse{

    @ApiModelProperty(value = "职位信息集合 包含分页信息")
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
