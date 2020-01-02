package com.swtl.wz.service.article;

import com.swtl.wz.entity.vo.response.article.ArticleResponse;

/**
 * 软文
 */
public interface IArticleService {
    /**
     * 查询软文信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    ArticleResponse listArticle(int pageNum, int pageSize);


}
