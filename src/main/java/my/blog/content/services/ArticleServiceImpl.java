package my.blog.content.services;

import my.blog.account.api.clients.AccountClient;
import my.blog.account.api.model.UserModel;
import my.blog.comm.base.pub.MyManagerException;
import my.blog.comm.base.tools.JsonTools;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.resources.entity.Article;
import my.blog.content.resources.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

        try {
            UserModel userModel = accountClient.findUserById(articleModel.getUserId());
            if(userModel == null || userModel.getStatus() != UserModel.UserStatus.NORMAL)
                throw new MyManagerException("用户信息异常");
            System.out.println("userModel:"+ JsonTools.writeValueAsString(userModel));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
