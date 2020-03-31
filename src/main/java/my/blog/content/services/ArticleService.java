package my.blog.content.services;

import my.blog.content.common.pub.MyManagerException;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.resources.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findByUserId(String userId);

    String createArticle(CreateArticleModel articleModel) throws MyManagerException;
}
