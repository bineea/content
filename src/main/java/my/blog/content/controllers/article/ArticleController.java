package my.blog.content.controllers.article;

import my.blog.content.resources.entity.Article;
import my.blog.content.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public List<Article> findByUserId(@PathVariable("userId") String userId) {
        List<Article> resList = articleService.findByUserId(userId);
        System.out.println(resList.get(0).toJson());
        return resList;
    }
}
