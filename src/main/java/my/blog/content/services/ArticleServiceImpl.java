package my.blog.content.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value = "75"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    //断路器超时时间
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    //断路器统计信息的滚动窗口
                    @HystrixProperty(name="metrics.rollingStats.timeInMilloseconds", value = "15000"),
                    //断路器并不是最后统计信息，而是按照bucket来统计，bucket数量为3，则是15000/3=5000ms，每5000ms统计一次数据
                    @HystrixProperty(name="metrics.rollingStats.numBuckets", value = "3")
            },
            threadPoolKey = "contentDBThreadPool"
    )
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
