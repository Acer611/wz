package com.swtl.wz.entity.vo.response.banner;

import com.github.pagehelper.PageInfo;
import com.swtl.wz.entity.po.article.ArticleEntity;
import com.swtl.wz.entity.po.banner.Banner;
import com.swtl.wz.entity.po.common.ConfigJobCategory;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class HomeResponse extends CommonResponse {

    @ApiModelProperty("轮播图的的实体")
    private List<Banner> bannerList;

    @ApiModelProperty("职业分类信息集合")
    private List<ConfigJobCategory> configJobCategoryList;

    @ApiModelProperty(value = "软文信息集合")
    private List<ArticleEntity> articleEntityList;

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public List<ConfigJobCategory> getConfigJobCategoryList() {
        return configJobCategoryList;
    }

    public void setConfigJobCategoryList(List<ConfigJobCategory> configJobCategoryList) {
        this.configJobCategoryList = configJobCategoryList;
    }

    public List<ArticleEntity> getArticleEntityList() {
        return articleEntityList;
    }

    public void setArticleEntityList(List<ArticleEntity> articleEntityList) {
        this.articleEntityList = articleEntityList;
    }
}
