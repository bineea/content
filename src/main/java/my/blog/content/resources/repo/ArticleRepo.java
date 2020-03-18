package my.blog.content.resources.repo;

import my.blog.content.resources.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, String> {

    List<Article> findByUserId(String userId);
}
