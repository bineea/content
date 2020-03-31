package my.blog.content.services;

import my.blog.content.clients.AccountClient;
import my.blog.content.common.pub.MyManagerException;
import my.blog.content.config.ServiceConfig;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.model.UserModel;
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
    @Autowired
    private AccountClient accountClient;


    @Override
    public List<Article> findByUserId(String userId) {
        return articleRepo.findByUserId(userId);
    }

    @Override
    public String createArticle(CreateArticleModel articleModel) throws MyManagerException {
        UserModel userModel = accountClient.findUserById(articleModel.getUserId());
        if(userModel == null || userModel.getStatus() != UserModel.UserStatus.NORMAL)
            throw new MyManagerException("用户信息异常");

        System.out.println("userModel:"+userModel.toJson());
        return null;
    }
}
