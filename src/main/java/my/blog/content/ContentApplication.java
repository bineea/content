package my.blog.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication 告诉Spring Boot框架，这是项目的引导类。实现服务的核心初始化逻辑*/
@SpringBootApplication
public class ContentApplication {

    public static void main(String[] args) {
        /*调用启动Spring Boot服务*/
        SpringApplication.run(ContentApplication.class, args);    }

}
