package com.swtl.wz.controller.common;

import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.po.version.VersionEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import com.swtl.wz.entity.vo.response.common.*;
import com.swtl.wz.entity.vo.response.version.VersionResponse;
import com.swtl.wz.service.common.ILocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "通用信息接口" ,value = "获取省 城市,一级职业，二级职业的的接口",description = "地点相关操作，包括 获取省份，省份下面的城市，一级职业分类，二级职业分类的接口 ")
@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private ILocationService locationService;



    /**
     * 获取所有城市信息
     * @return
     */
    @ApiOperation(value = "获取所有城市信息", notes = "获取所有城市信息")
    @RequestMapping(value = "/allCity", method = RequestMethod.GET)
    @ResponseBody
    public CityResponse allCity(@RequestHeader(required = false, value = "token") String token){
        CityResponse cityResponse = locationService.findAllCity();
        return cityResponse;
    }



    /**
     * 获取城市下的区县信息
     * @return
     */
    @ApiOperation(value = "获取城市下区县信息", notes = "获取城市下区县信息")
    @RequestMapping(value = "/findAreas", method = RequestMethod.GET)
    @ResponseBody
    public AreasResponse findAreas(@RequestHeader(required = false, value = "token") String token,
                                  @ApiParam(value = "市的id") @RequestParam(name = "cid") String cid){
        AreasResponse areasResponse = locationService.findAreas(cid);
        return areasResponse;
    }



    /**
     * 根据城市名称获取城市ID
     * @return
     */
    @ApiOperation(value = "根据城市名称获取城市ID", notes = "根据城市名称获取城市ID")
    @RequestMapping(value = "/findCityId", method = RequestMethod.GET)
    @ResponseBody
    public CityResponse findCityId(@RequestHeader(required = false, value = "token") String token,
                                   @ApiParam(value = "城市名称") @RequestParam(name = "cityName") String cityName
    ){
        CityResponse cityResponse  = new CityResponse();
        if(cityName == null){
            cityResponse.setRetCode(70001);
            cityResponse.setRetMsg("城市不能为空！");
            return  cityResponse;
        }

        cityResponse = locationService.findCityId(cityName);
        return cityResponse;
    }






    /**
     * 获取一级职业分类信息
     * @return
     */
    @ApiOperation(value = "获取一级职业分类信息", notes = "获取一级职业分类信息")
    @RequestMapping(value = "/findAllJOB", method = RequestMethod.GET)
    @ResponseBody
    public JobTitleResponse findAllJOB(@RequestHeader(required = false, value = "token") String token){
        JobTitleResponse jobTitleResponse = locationService.findAllJobTitle();
        return jobTitleResponse;
    }


    /**
     * 获取二级职业分类信息
     * @return
     */
    @ApiOperation(value = "获取二级职业分类信息", notes = "获取二级职业分类信息")
    @RequestMapping(value = "/findJobTitleDetail", method = RequestMethod.GET)
    @ResponseBody
    public JobTitleDetailResponse findJobTitleDetail(@RequestHeader(required = false, value = "token") String token,
                        @ApiParam(value = "一级职业分类 【classId】 !!!") @RequestParam(name = "classID") String classId){
        JobTitleDetailResponse jobTitleDetailResponse = locationService.findJobTitleDetail(classId);
        return jobTitleDetailResponse;
    }


    /**
     * 获取一级职业分类信息
     * @return
     */
    @ApiOperation(value = "获取一级职业分类信息和二级职业分类", notes = "获取一级职业分类和二级职业信息")
    @RequestMapping(value = "/findAllJOBAndJobTitle", method = RequestMethod.GET)
    @ResponseBody
    public JobTitleResponse findAllJOBAndJobTitle(@RequestHeader(required = false, value = "token") String token){
        JobTitleResponse jobTitleResponse = locationService.findAllJOBAndJobTitle();
        return jobTitleResponse;
    }


    /**
     * 客服功能是否开启
     * @return
     */
    @ApiOperation(value = "客服功能是否开启查询", notes = "客服功能是否开启查询")
    @RequestMapping(value = "/kfOpenOrClose", method = RequestMethod.GET)
    @ResponseBody
    public Map kfOpenOrClose(){

        return  locationService.kfOpenOrClose();

    }


    /**
     * 获取客服列表信息
     * @return
     */
    @ApiOperation(value = "获取客服列表信息", notes = "获取客服列表信息")
    @RequestMapping(value = "/listKfDetail", method = RequestMethod.GET)
    @ResponseBody
    public KfDetailResponse listKfDetail(){

        KfDetailResponse kfDetailResponse = new KfDetailResponse();
        List<KfDetail> list = locationService.listKfDetail();
        kfDetailResponse.setKfDetailList(list);

        return kfDetailResponse;

    }

    /**
     * 获取版本信息
     * @return
     */
    @ApiOperation(value = "获取版本信息", notes = "获取版本信息")
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    @ResponseBody
    public VersionResponse version(@ApiParam(value = "token") @RequestHeader(required = false, value = "token") String token,
                                   @ApiParam(value = "版本号") @RequestHeader(required = true, value = "version") String version,
                                   @ApiParam(value = "类型 1 ios  2  android") @RequestHeader(required = true, value = "type") Integer type){

        VersionResponse versionResponse = new VersionResponse();
        String verStr = version.replace(".","");
        Integer ver = Integer.parseInt(verStr);

        if(ver<100){
            versionResponse.setRetCode(6009);
            versionResponse.setRetMsg("请检查传入版本号是否符合格式,如（1.0.0）");
            return  versionResponse;
        }


        versionResponse = locationService.version(version,type);

        return  versionResponse;

    }

    /**
     * 获取下载地址信息
     * @return
     */
    @ApiOperation(value = "获取下载地址信息", notes = "获取下载地址信息")
    @RequestMapping(value = "/downloadUrl", method = RequestMethod.GET)
    @ResponseBody
    public List<VersionEntity> downloadUrl(){


        List<VersionEntity> versionEntityList = locationService.downloadUrl();

        return  versionEntityList;

    }







}
