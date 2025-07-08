package com.damian.newsapi.service.impl;

import com.damian.newsapi.dto.NewsDTO;
import com.damian.newsapi.entity.News;
import com.damian.newsapi.entity.NewsCategory;
import com.damian.newsapi.exception.InvalidNewsException;
import com.damian.newsapi.repo.NewsRepository;
import com.damian.newsapi.service.NewsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> getNewsById(String id) {
        return newsRepository.findById(id);
    }

    @Override
    public News createNews(NewsDTO news) {
        if (getNewsById(news.newsId()).isEmpty()) {
            var newsEntity = new News();
            newsEntity.setNewsId(news.newsId());
            newsEntity.setHeadLine(news.headLine());
            newsEntity.setNewsContent(news.newsContent());

            var categories = List.of(news.newsCategories());
            for (NewsCategory category : categories) {
                category.setNews(newsEntity);
            }
            newsEntity.setNewsCategories(categories);
            return newsRepository.save(newsEntity);
        }
        log.warn("News with ID {} already exists", news.newsId());
        throw new InvalidNewsException("News with ID " + news.newsId() + " already exists.");
    }
}
