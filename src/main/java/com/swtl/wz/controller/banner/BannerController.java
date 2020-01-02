package com.swtl.wz.controller.banner;

import com.swtl.wz.entity.po.common.ConfigJobCategory;
import com.swtl.wz.entity.vo.response.banner.BannerResponse;
import com.swtl.wz.entity.vo.response.banner.HomeResponse;
import com.swtl.wz.entity.vo.response.common.ConfigJobCategoryResponse;
import com.swtl.wz.entity.vo.response.user.UserResponse;
import com.swtl.wz.service.banner.IBannerService;
import com.swtl.wz.service.common.ILocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * banner的接口
 */

@Api(tags = "获取banner的接口" ,value = "banner的接口",description = "获取首页banner信息，和首页职位分类信息 ")
@RestController
@RequestMapping("/api/banner")
public class BannerController {

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ILocationService locationService;
    /**
     * 查询banner列表
     * @return
     */
    @ApiOperation(value = "查询banner列表")
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BannerResponse listBanner(@RequestHeader(required = false, value = "token") String token){
        BannerResponse bannerResponse = new BannerResponse();
      /*  String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            bannerResponse.setRetCode(5002);
            bannerResponse.setRetMsg("用户不存在！");
            return  bannerResponse;
        }*/

        bannerResponse = bannerService.listBanner();
        return bannerResponse;
    }


    /**
     * 获取职业分类的接口
     * @param token
     * @return
     */
    @ApiOperation(value = "首页取职业分类的列表")
    @ResponseBody
    @RequestMapping(value = "/listJobCategory",method = RequestMethod.GET)
    public ConfigJobCategoryResponse listJobCategory(@RequestHeader(required = false, value = "token") String token){

        ConfigJobCategoryResponse configJobCategoryResponse = new ConfigJobCategoryResponse();
       /* String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            configJobCategoryResponse.setRetCode(5002);
            configJobCategoryResponse.setRetMsg("用户不存在！");
            return  configJobCategoryResponse;
        }*/

        configJobCategoryResponse = locationService.listJobCategory();
        return configJobCategoryResponse;
    }



    /**
     * 查询首页信息
     * @return
     */
    @ApiOperation(value = "查询首页信息")
    @ResponseBody
    @RequestMapping(value = "/homeInfo",method = RequestMethod.GET)
    public HomeResponse homeInfo(@RequestHeader(required = false, value = "token") String token){
        HomeResponse homeResponse = new HomeResponse();
       /* String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            homeResponse.setRetCode(5002);
            homeResponse.setRetMsg("用户不存在！");
            return  homeResponse;
        }*/

        homeResponse = bannerService.homeInfo();
        return homeResponse;
    }

}
