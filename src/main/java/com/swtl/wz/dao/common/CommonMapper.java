package com.swtl.wz.dao.common;

import com.swtl.wz.entity.po.banner.Banner;
import com.swtl.wz.entity.po.common.*;
import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.po.version.VersionEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommonMapper {


    /**
     * 查找所有省份的信息
     * @return
     */
    @Select("SELECT pid,provincial from  provincial ")
    List<Provoncoal> allProvincial();

    /**
     * 查找省份下的城市信息
     * @param pid
     * @return
     */
    @Select("SELECT cid,city,pid from city where pid=#{pid}")
    List<City> findCity(String pid);

    /**
     * 获取一级职业分类信息
     * @return
     */
    @Select("SELECT id,title,status,classId,classDesc,classLevel from  job_title where status = 0 ")
    List<JobTitle> findAllJobTitle();

    /**
     * 获取二级职业分类信息
     * @param classID
     * @return
     */
    @Select("SELECT id,pid,name,status,classificationId, classifyDesc,parentId,classLevel from  job_title_detail where status = 0 and parentId=#{classID}")
    List<JobTitleDetail> findJobTitleDetail(String classID);

    /**
     * 获取省份和省份下城市信息
     * @return
     */
    @Select("SELECT pid,provincial from  provincial ")
    @Results({
            @Result(id = true,column="pid",property="pid"),
            @Result(column="provincial",property="provincial"),
            @Result(column="pid",property="cityList",
                    many=@Many(
                            select="com.swtl.wz.dao.common.CommonMapper.findCity",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<Provoncoal> allProvincialAndCity();

    /**
     * 获取一级职业和二级职业信息
     * @return
     */
    @Select("SELECT id,title,status,classId,classDesc,classLevel from  job_title where status = 0 ")
    @Results({
            @Result(id = true,column="id",property="id"),
            @Result(column="title",property="title"),
            @Result(column="status",property="status"),
            @Result(column="classId",property="classId"),
            @Result(column="classDesc",property="classDesc"),
            @Result(column="classLevel",property="classLevel"),
            @Result(column="classId",property="jobTitleDetailList",
                    many=@Many(
                            select="com.swtl.wz.dao.common.CommonMapper.findJobTitleDetail",
                            fetchType= FetchType.EAGER
                    )
            )
    })
    List<JobTitle> findAllJOBAndJobTitle();


    /**
     * 查询轮播图列表
     * @return
     */
    @Select("SELECT id, IFNULL(banner,'') AS banner,  IFNULL(targetUrl,'') AS targetUrl, IFNULL(`status`,0) AS `status`, createTime,updateTime FROM t_banner ORDER BY updateTime DESC")
    List<Banner> listBanner();

    /**
     * 获取职业分类信息的列表
     * @return
     */
    @Select("SELECT id,jobCategory,`status`,type,IFNULL(icon,'')icon,IFNULL(url,'')url from config_job_category where `status` =0")
    List<ConfigJobCategory> listJobCategory();

    /**
     * 查询客服功能是否开启
     * @return
     */
    @Select("select * from t_kf_enable")
    Map kfOpenOrClose();

    /**
     * 获取客服列表信息
     * @return
     */
    @Select("SELECT id,IFNULL(confId,0)confId, IFNULL(qq,'')qq, IFNULL(wechat,'')wechat, IFNULL(aliPay,'')aliPay,IFNULL(`name`,'')`name`,IFNULL(url,'')url FROM t_kf_detail")
    List<KfDetail> listKfDetail();

    /**
     * 查询版本信息
     * @param type
     * @return
     */
    @Select("SELECT * FROM t_version WHERE type=#{type} ")
    VersionEntity findVersionByType(Integer type);

    /**
     * 获取下载地址
     * @return
     */
    @Select("SELECT * FROM t_version  ")
    List<VersionEntity> downloadUrl();

    /**
     * 根据城市名称查询城市ID
     * @param cityName
     * @return
     */
    @Select("SELECT * FROM t_city WHERE alipayName  LIKE CONCAT('%',#{0},'%') " )
    City findCityId(String cityName);


    /**
     * 查找所有城市信息
     * @return
     */
    @Select("SELECT * from  t_city ORDER BY spellCode")
    List<City> findAllCity();

    /**
     * 查找城市下的区县信息
     * @param cid
     * @return
     */
    @Select("SELECT * FROM t_county WHERE townId =#{cid}")
    List<AreaEntity> findAreas(String cid);
}
