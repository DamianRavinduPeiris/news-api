package com.damian.newsapi.service.impl;

import com.damian.newsapi.entity.NewsCategory;
import com.damian.newsapi.repo.NewsCategoryRepository;
import com.damian.newsapi.service.NewsCategoryService;
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
public class NewsCategoryServiceImpl implements NewsCategoryService {

    private final NewsCategoryRepository newsCategoryRepository;

    @Override
    public List<NewsCategory> getAllCategories() {
        return newsCategoryRepository.findAll();
    }

    @Override
    public Optional<NewsCategory> getCategoryById(String id) {
        return newsCategoryRepository.findById(id);
    }

    @Override
    public NewsCategory createCategory(NewsCategory category) {
        return newsCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        newsCategoryRepository.deleteById(id);
    }
}

