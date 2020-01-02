package com.swtl.wz.service.banner;

import com.swtl.wz.dao.article.ArticleMapper;
import com.swtl.wz.dao.common.CommonMapper;
import com.swtl.wz.entity.po.article.ArticleEntity;
import com.swtl.wz.entity.po.banner.Banner;
import com.swtl.wz.entity.po.common.ConfigJobCategory;
import com.swtl.wz.entity.vo.response.banner.BannerResponse;
import com.swtl.wz.entity.vo.response.banner.HomeResponse;
import com.swtl.wz.service.article.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bannerService")
public class BannerServiceImpl implements IBannerService {


    @Autowired
    CommonMapper commonMapper;

    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 获取banner 信息列表
     * @return
     */
    @Override
    public BannerResponse listBanner() {
        BannerResponse bannerResponse = new BannerResponse();
        List<Banner> bannerList = commonMapper.listBanner();
        bannerResponse.setBannerList(bannerList);
        return bannerResponse;
    }

    @Override
    public HomeResponse homeInfo() {

        HomeResponse homeResponse = new HomeResponse();
        //banner
        List<Banner> bannerList = commonMapper.listBanner();
        homeResponse.setBannerList(bannerList);

        //分类  躺赚  简单
        List<ConfigJobCategory> configJobCategoryList = commonMapper.listJobCategory();
        homeResponse.setConfigJobCategoryList(configJobCategoryList);

        List<ArticleEntity> articleEntityList = articleMapper.listArticleTOP2();
        homeResponse.setArticleEntityList(articleEntityList);
        return homeResponse;
    }
}
