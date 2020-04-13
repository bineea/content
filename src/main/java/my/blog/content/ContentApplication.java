package my.blog.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication 告诉Spring Boot框架，这是项目的引导类。实现服务的核心初始化逻辑
@SpringBootApplication

//允许访问/refresh端点，强制Spring Boot应用重新读取程序配置
@RefreshScope
//@EnableEurekaClient

//启用Feign客户端
@EnableFeignClients(basePackages = {"my.blog.account.api"})
public class ContentApplication {

    public static void main(String[] args) {
        /*调用启动Spring Boot服务*/
        SpringApplication.run(ContentApplication.class, args);    }

}
