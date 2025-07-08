package com.damian.newsapi.service.impl;

import com.damian.newsapi.dto.NewsDTO;
import com.damian.newsapi.entity.News;
import com.damian.newsapi.entity.NewsCategory;
import com.damian.newsapi.exception.InvalidNewsException;
import com.damian.newsapi.repo.NewsCategoryRepository;
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
    private final NewsCategoryRepository newsCategoryRepository;

    @Override
    public List<NewsDTO> getAllNews() {
        var allNews = newsRepository.findAll();
        return allNews.stream()
                .map(news -> new NewsDTO(
                        news.getNewsId(),
                        news.getHeadLine(),
                        news.getNewsContent(),
                        news.getNewsCategories().toArray(new NewsCategory[0])
                ))
                .toList();
    }

    @Override
    public Optional<News> getNewsById(String id) {
        return newsRepository.findById(id);
    }

    @Override
    public NewsDTO createNews(NewsDTO news) {
        if (getNewsById(news.newsId()).isEmpty()) {
            var newsEntity = new News();
            newsEntity.setNewsId(news.newsId());
            newsEntity.setHeadLine(news.headLine());
            newsEntity.setNewsContent(news.newsContent());

            for (NewsCategory category : news.newsCategories()) {
                if (category.getCategoryId() != null && !category.getCategoryId().isBlank()) {
                    var categoryEntity = newsCategoryRepository.findById(category.getCategoryId())
                            .orElseGet(() -> {
                                var newCategory = new NewsCategory();
                                newCategory.setCategoryId(category.getCategoryId());
                                newCategory.setCategoryName(category.getCategoryName());
                                return newsCategoryRepository.save(newCategory);
                            });
                    categoryEntity.getNews().add(newsEntity);
                    newsEntity.getNewsCategories().add(categoryEntity);
                } else {
                    var newCategory = new NewsCategory();
                    newCategory.setCategoryId(java.util.UUID.randomUUID().toString());
                    newCategory.setCategoryName(category.getCategoryName());
                    newCategory.getNews().add(newsEntity);
                    newsEntity.getNewsCategories().add(newsCategoryRepository.save(newCategory));
                }
            }
            var savedNews = newsRepository.save(newsEntity);
            log.info("News with ID {} created successfully", savedNews.getNewsId());
            return new NewsDTO(
                    savedNews.getNewsId(),
                    savedNews.getHeadLine(),
                    savedNews.getNewsContent(),
                    savedNews.getNewsCategories().toArray(new NewsCategory[0])
            );
        }
        log.warn("News with ID {} already exists", news.newsId());
        throw new InvalidNewsException("News with ID " + news.newsId() + " already exists.");
    }
}
