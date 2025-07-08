package com.damian.newsapi.repo;

import com.damian.newsapi.entity.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsCategoryRepository extends JpaRepository<NewsCategory, String> {
}

