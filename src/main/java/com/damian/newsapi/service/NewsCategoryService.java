package com.damian.newsapi.service;

import com.damian.newsapi.entity.NewsCategory;
import java.util.List;
import java.util.Optional;

public interface NewsCategoryService {
    List<NewsCategory> getAllCategories();
    Optional<NewsCategory> getCategoryById(String id);
    NewsCategory createCategory(NewsCategory category);
    void deleteCategory(String id);
}

