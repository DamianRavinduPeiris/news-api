package com.damian.newsapi.controllers;

import com.damian.newsapi.entity.NewsCategory;
import com.damian.newsapi.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class NewsCategoryController {
    @Autowired
    private NewsCategoryService newsCategoryService;

    @GetMapping
    public List<NewsCategory> getAllCategories() {
        return newsCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsCategory> getCategoryById(@PathVariable String id) {
        return newsCategoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NewsCategory createCategory(@RequestBody NewsCategory category) {
        return newsCategoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        newsCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
