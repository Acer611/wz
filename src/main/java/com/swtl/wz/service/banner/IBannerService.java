package com.swtl.wz.service.banner;


import com.swtl.wz.entity.vo.response.banner.BannerResponse;
import com.swtl.wz.entity.vo.response.banner.HomeResponse;

/**
 * 轮播图的业务层
 */
public interface IBannerService {

    /**
     * 获取轮播图的列表
     * @return
     */
    public BannerResponse listBanner() ;

    /**
     * 获取首页信息
     * @return
     */
    HomeResponse homeInfo();
}
