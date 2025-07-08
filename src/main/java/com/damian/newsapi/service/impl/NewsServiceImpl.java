package com.damian.newsapi.service.impl;

import com.damian.newsapi.entity.News;
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
    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}

