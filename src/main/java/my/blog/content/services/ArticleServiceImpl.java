package my.blog.content.services;

import my.blog.content.config.ServiceConfig;
import my.blog.content.resources.entity.Article;
import my.blog.content.resources.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ServiceConfigurationError;

@Service
public class ArticleServiceImpl extends AbstractService implements ArticleService {

    @Autowired
    private ArticleRepo articleRepo;


    @Override
    public List<Article> findByUserId(String userId) {
        return articleRepo.findByUserId(userId);
    }
}
