package com.wesew.core.repo;

import com.wesew.core.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author vladyslav.yemelianov
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
