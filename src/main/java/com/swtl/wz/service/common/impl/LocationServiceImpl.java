package com.swtl.wz.service.common.impl;

import com.swtl.wz.dao.common.CommonMapper;
import com.swtl.wz.entity.po.common.*;
import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.po.version.VersionEntity;
import com.swtl.wz.entity.vo.response.common.*;
import com.swtl.wz.entity.vo.response.version.VersionResponse;
import com.swtl.wz.service.common.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 一些通用的的业务 （城市信息  工作职业信息等）
 */
@Service("locationService")
public class LocationServiceImpl implements ILocationService {

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 获取所有省份的信息
     * @return
     */
    @Override
    public ProvincialResponse allProvincial() {
        ProvincialResponse provincialResponse = new ProvincialResponse();

        List<Provoncoal> provincialList = commonMapper.allProvincial();
        provincialResponse.setProvoncoalList(provincialList);

        provincialResponse.setRetMsg("获取省份信息成功");
        return provincialResponse;
    }

    /**
     * 获取省份下的城市信息
     * @param pid
     * @return
     */
    @Override
    public CityResponse findCity(String pid) {
        CityResponse cityResponse = new CityResponse();
        List<City> resCityList = new ArrayList<>();
        List<City> cityList = commonMapper.findCity(pid);
        City city = new City();
        /*city.setCid(-1L);
        city.setCity("全部");
        city.setPid(-1L);*/
        resCityList.add(city);
        resCityList.addAll(cityList);
        cityResponse.setCityList(resCityList);
        cityResponse.setRetMsg("获取城市信息成功");
        return cityResponse;
    }

    /**
     * 获取省份和省份下的城市信息
     * @return
     */
    @Override
    public ProvincialResponse allProvincialAndCity() {
        ProvincialResponse provincialResponse = new ProvincialResponse();
        //List<Provoncoal> resultProvoncoalList = new ArrayList<>();
        List<Provoncoal> provincialList = commonMapper.allProvincialAndCity();
      /*  Provoncoal provoncoal = new Provoncoal();
        provoncoal.setPid(0L);
        provoncoal.setProvincial("全部");
        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCid(0L);
        city.setCity("全部");
        city.setPid(0L);
        cityList.add(city);
        provoncoal.setCityList(cityList);
        provincialList.add(provoncoal);


        resultProvoncoalList.add(provoncoal);
        resultProvoncoalList.addAll(provincialList);
*/
        provincialResponse.setProvoncoalList(provincialList);
        provincialResponse.setRetMsg("获取省份和城市信息成功");
        return provincialResponse;
    }

    /**
     * 获取一级职业分类信息
     * @return
     */
    @Override
    public JobTitleResponse findAllJobTitle() {
        JobTitleResponse jobTitleResponse = new JobTitleResponse();
        List<JobTitle> jobTitleList = commonMapper.findAllJobTitle();
        jobTitleResponse.setJobTitleList(jobTitleList);
        jobTitleResponse.setRetMsg("获取一级职业分类信息成功");
        return jobTitleResponse;
    }

    /**
     * 获取一级职业分类下的二级职业分类
     * @param pid
     * @return
     */
    @Override
    public JobTitleDetailResponse findJobTitleDetail(String classID) {
        JobTitleDetailResponse jobTitleDetailResponse = new JobTitleDetailResponse();
        List<JobTitleDetail> jobTitleDetailList = commonMapper.findJobTitleDetail(classID);
        jobTitleDetailResponse.setJobTitleDetailList(jobTitleDetailList);
        jobTitleDetailResponse.setRetMsg("获取二级职业分类信息成功");
        return jobTitleDetailResponse;
    }

    /**
     * 获取一级职业和二级职业信息
     * @return
     */
    @Override
    public JobTitleResponse findAllJOBAndJobTitle() {
        JobTitleResponse jobTitleResponse = new JobTitleResponse();
       /* List<JobTitle> resultJobTitleList = new ArrayList<>();*/
        List<JobTitle> jobTitleList = commonMapper.findAllJOBAndJobTitle();
        /*JobTitle jobTitle = new JobTitle();
        jobTitle.setId(0L);
        jobTitle.setTitle("全部");
        jobTitle.setStatus(0);
        List<JobTitleDetail> jobTitleDetailList = new ArrayList<>();
        JobTitleDetail jobTitleDetail = new JobTitleDetail();
        jobTitleDetail.setId(0L);
        jobTitleDetail.setName("全部");
        jobTitleDetail.setPid(0L);
        jobTitleDetail.setStatus(0);
        jobTitleDetailList.add(jobTitleDetail);
        jobTitle.setJobTitleDetailList(jobTitleDetailList);
        jobTitleList.add(jobTitle);
        resultJobTitleList.add(jobTitle);
        resultJobTitleList.addAll(jobTitleList);*/

        jobTitleResponse.setJobTitleList(jobTitleList);
        jobTitleResponse.setRetMsg("获取一级职业和二级职业信息成功");
        return jobTitleResponse;
    }

    /**
     * 获取职业分类信息
     * @return
     */
    @Override
    public ConfigJobCategoryResponse listJobCategory() {
        ConfigJobCategoryResponse configJobCategoryResponse = new ConfigJobCategoryResponse();

        List<ConfigJobCategory> configJobCategoryList = commonMapper.listJobCategory();
        configJobCategoryResponse.setConfigJobCategoryList(configJobCategoryList);
        return configJobCategoryResponse;
    }

    /**
     * 查询客服功能是否开启
     * @return
     */
    @Override
    public Map kfOpenOrClose() {
        Map map = commonMapper.kfOpenOrClose();
        map.put("retCode",200);
        map.put("retMsg","success");
        return map;
    }

    /**
     * 获取客服列表信息
     * @return
     */
    @Override
    public List<KfDetail> listKfDetail() {
        List<KfDetail> kfDetailList = commonMapper.listKfDetail();
        return kfDetailList;
    }

    /**
     * 获取版本信息
     * @param version
     * @param type
     * @return
     */
    @Override
    public VersionResponse version(String version, Integer type) {
        VersionResponse versionResponse = new VersionResponse();
        VersionEntity versionEntity = commonMapper.findVersionByType(type);

        if(null==versionEntity){
            return  new VersionResponse();
        }

        String lastVersion = versionEntity.getLastVersion();
        if(Integer.parseInt(lastVersion.replace(".",""))>Integer.parseInt(version.replace(".",""))){
            versionResponse.setCompel(true);
        }else{
            versionResponse.setCompel(false);
        }
        versionResponse.setVersionEntity(versionEntity);
        return versionResponse;
    }

    /**
     * 获取下载地址
     * @return
     */
    @Override
    public List<VersionEntity> downloadUrl() {
        List<VersionEntity> versionEntitys = commonMapper.downloadUrl();
        return versionEntitys;
    }

    /**
     * 根据城市名称查找城市ID
     * @param cityName
     * @return
     */
    @Override
    public CityResponse findCityId(String cityName) {
        CityResponse cityResponse = new CityResponse();
        City city = commonMapper.findCityId(cityName);
        if(city == null){
            cityResponse.setRetCode(7002);
            cityResponse.setRetMsg("城市信息传参有误，没有当前城市！");
            return cityResponse;
        }
        cityResponse.setCity(city);
        return cityResponse;
    }


    /**
     * 查找所有城市信息
     * @return
     */
    @Override
    public CityResponse findAllCity() {
        CityResponse cityResponse = new CityResponse();
        List<City> resCityList = new ArrayList<>();
        List<City> cityList = commonMapper.findAllCity();
        resCityList.addAll(cityList);
        cityResponse.setCityList(resCityList);
        return cityResponse;
    }

    /**
     * 查找城市下的区县信息
     * @param cid
     * @return
     */
    @Override
    public AreasResponse findAreas(String cid) {
        AreasResponse areasResponse = new AreasResponse();
        List<AreaEntity> resAreasList = new ArrayList<>();
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setAreaId(-1L);
        areaEntity.setAreaName("不限");
        areaEntity.setTownId(-1L);
        areaEntity.setId(-1L);
        resAreasList.add(areaEntity);
        List<AreaEntity> areaEntityList = commonMapper.findAreas(cid);
        resAreasList.addAll(areaEntityList);
        areasResponse.setAreaEntity(resAreasList);
        return areasResponse;
    }
}
