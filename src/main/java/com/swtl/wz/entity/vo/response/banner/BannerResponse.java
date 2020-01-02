package com.swtl.wz.entity.vo.response.banner;

import com.swtl.wz.entity.po.banner.Banner;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 轮播图的返回对象
 */
public class BannerResponse extends CommonResponse {

    @ApiModelProperty("轮播图的的实体")
    private List<Banner> bannerList;

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        for (Banner banner:bannerList) {
            if(banner.getBanner()==null){
                banner.setBanner("");
            }
            if(banner.getTargetUrl()==null){
                banner.setTargetUrl("");
            }
        }
        this.bannerList = bannerList;
    }
}
