package com.damian.newsapi.service;

import com.damian.newsapi.entity.News;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> getAllNews();
    Optional<News> getNewsById(Long id);
    News createNews(News news);
    void deleteNews(Long id);
}

