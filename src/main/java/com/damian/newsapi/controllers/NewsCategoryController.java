package com.damian.newsapi.controllers;

import com.damian.newsapi.entity.NewsCategory;
import com.damian.newsapi.service.NewsCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NewsCategoryController {

    private final NewsCategoryService newsCategoryService;

    @GetMapping
    public List<NewsCategory> getAllCategories() {
        return newsCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsCategory> getCategoryById(@PathVariable String id) {
        return newsCategoryService.getCategoryById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
