package com.swtl.wz.service.article;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swtl.wz.dao.article.ArticleMapper;
import com.swtl.wz.entity.po.article.ArticleEntity;
import com.swtl.wz.entity.po.message.MessageEntity;
import com.swtl.wz.entity.vo.response.article.ArticleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 软文信息的业务处理层
 */
@Service(value = "articleService")
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    /**
     * 查询软文信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ArticleResponse listArticle(int pageNum, int pageSize) {
        ArticleResponse articleResponse = new ArticleResponse();

        PageHelper.startPage(pageNum, pageSize);
        List<ArticleEntity> articleEntityList = articleMapper.listArticle();

        PageInfo result = new PageInfo(articleEntityList);
        articleResponse.setPageInfo(result);
        //articleResponse.setObject(result);
        return articleResponse;
    }
}
