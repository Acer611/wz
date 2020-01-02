package com.swtl.wz.service.common;

import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.po.version.VersionEntity;
import com.swtl.wz.entity.vo.response.common.*;
import com.swtl.wz.entity.vo.response.version.VersionResponse;

import java.util.List;
import java.util.Map;

/**
 * 一些通用的的业务 （城市信息  工作职业信息等）
 */
public interface ILocationService {

    /**
     * 查找所有的省份信息
     * @return
     */
    ProvincialResponse allProvincial();

    /**
     * 获取省份下的城市纤细
     * @param pid
     * @return
     */

    CityResponse findCity(String pid);

    /**
     * 获取省份和省份下的城市信息
     * @return
     */
    ProvincialResponse allProvincialAndCity();

    /**
     * 获取一级职业分类信息
     * @return
     */
    JobTitleResponse findAllJobTitle();

    /**
     * 获取一级职业分类下的二级职业信息
     * @param pid
     * @return
     */
    JobTitleDetailResponse findJobTitleDetail(String pid);

    /**
     * 获取一级职业分类和二级职业信息
     * @return
     */

    JobTitleResponse findAllJOBAndJobTitle();

    /**
     * 获取职业分类信息
     * @return
     */
    ConfigJobCategoryResponse listJobCategory();

    /**
     * 查询客服功能是否开启
     * @return
     */
    Map kfOpenOrClose();

    /**
     * 获取客服列表
     * @return
     */
    List<KfDetail> listKfDetail();

    /**
     * 获取版本信息
     * @param version
     * @param type
     * @return
     */
    VersionResponse version(String version, Integer type);

    /**
     * 获取下载地址
     * @return
     */
    List<VersionEntity> downloadUrl();

    /**
     * 根据城市名称查找城市ID
     * @param cityName
     * @return
     */
    CityResponse findCityId(String cityName);


    /**
     * 查找所有城市信息
     * @return
     */
    CityResponse findAllCity();

    /**
     * 查找城市下的区县信息
     * @param cid
     * @return
     */
    AreasResponse findAreas(String cid);
}
