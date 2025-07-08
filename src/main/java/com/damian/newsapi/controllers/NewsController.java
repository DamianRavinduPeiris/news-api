package com.damian.newsapi.controllers;


import com.damian.newsapi.dto.NewsDTO;
import com.damian.newsapi.entity.News;
import com.damian.newsapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/news",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<News> addNews(@RequestBody NewsDTO newsDTO){
        return ResponseEntity.ok(newsService.createNews(newsDTO));
    }
}
