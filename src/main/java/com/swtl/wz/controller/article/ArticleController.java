package com.swtl.wz.controller.article;


import com.swtl.wz.entity.vo.response.article.ArticleResponse;
import com.swtl.wz.service.article.IArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/***
 * 软文信息的接口
 */

@Api(tags = "获取软文信息的" ,value = "获取软文的信息列表",description = "获取软文的信息列表 ")
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 查询软文列表
     * @return
     */
    @ApiOperation(value = "查询软文信息列表")
    @ResponseBody
    @RequestMapping(value = "/listArticle",method = RequestMethod.GET)
    public ArticleResponse listArticle(@RequestHeader(required = false, value = "token") String token,
                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10")int pageSize){
        ArticleResponse articleResponse = new ArticleResponse();
      /*  String userId = stringRedisTemplate.opsForValue().get("User_GetUserByToken:" + token);
        if (userId==null){
            articleResponse.setRetCode(5002);
            articleResponse.setRetMsg("用户不存在！");
            return  articleResponse;
        }*/

        articleResponse = articleService.listArticle(pageNum,pageSize);
        return articleResponse;
    }


}
