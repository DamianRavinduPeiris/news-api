package com.damian.newsapi.repo;

import com.damian.newsapi.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}

