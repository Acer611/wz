package com.swtl.wz.entity.vo.response.message;

import com.github.pagehelper.PageInfo;
import com.swtl.wz.entity.po.message.MessageEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有消息的信息
 */
public class MessageResponse extends CommonResponse {


    @ApiModelProperty(value = "消息信息集合 包含分页信息")
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
