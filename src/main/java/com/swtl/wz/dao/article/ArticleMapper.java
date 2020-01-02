package com.swtl.wz.dao.article;

import com.swtl.wz.entity.po.article.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 软文的数据处理层
 */
@Mapper
public interface ArticleMapper {

    /**
     * 查询所有软文的信息列表 （创建时间倒序排序）
     * @return
     */
    @Select("SELECT id,ifnull(title,'')AS title,IFNULL(url,'')AS url,IFNULL(content, '') AS content," +
            "IFNULL(`status`, 0) AS `status`, IFNULL(`label`, '') AS `label`, IFNULL(`readTimes`, 0) AS `readTimes`," +
            "IFNULL(`createTime`, NOW()) AS `createTime`,IFNULL(`imgUrl`, '') AS imgUrl FROM t_article  ORDER BY createTime DESC" )
    List<ArticleEntity> listArticle();

    /**
     * 查询所有软文的信息列表 （查询软文信息）
     * @return
     */
    @Select("SELECT id,ifnull(title,'')AS title,IFNULL(url,'')AS url,IFNULL(content, '') AS content," +
            "IFNULL(`status`, 0) AS `status`, IFNULL(`label`, '') AS `label`, IFNULL(`readTimes`, 0) AS `readTimes`," +
            "IFNULL(`createTime`, NOW()) AS `createTime`, IFNULL(`imgUrl`, '') AS imgUrl FROM t_article ORDER BY createTime DESC limit 2 " )
    List<ArticleEntity> listArticleTOP2();
}
