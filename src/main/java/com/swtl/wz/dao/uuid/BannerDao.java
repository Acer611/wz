package com.swtl.wz.dao.uuid;

import com.swtl.wz.entity.po.banner.Banner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * banner处理层
 */
@Mapper
public interface BannerDao {

    @Select("select * from banner")
    List<Banner> list();
}
