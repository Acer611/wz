package com.swtl.wz.entity.vo.response.article;

import com.github.pagehelper.PageInfo;
import com.swtl.wz.entity.po.article.ArticleEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 软文返回对象实体信息
 */
public class ArticleResponse extends CommonResponse {

    @ApiModelProperty(value = "软文信息集合 包含分页信息")
    private PageInfo pageInfo;

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
