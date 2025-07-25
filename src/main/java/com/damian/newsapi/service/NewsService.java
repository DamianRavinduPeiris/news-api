package com.damian.newsapi.service;

import com.damian.newsapi.dto.NewsDTO;
import com.damian.newsapi.entity.News;
import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<NewsDTO> getAllNews();
    Optional<News> getNewsById(String id);
    NewsDTO createNews(NewsDTO newsDTO);
}

