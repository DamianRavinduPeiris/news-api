package com.damian.newsapi.controllers;


import com.damian.newsapi.dto.NewsDTO;
import com.damian.newsapi.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/news",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewsDTO> addNews(@RequestBody NewsDTO newsDTO){
        return ResponseEntity.ok(newsService.createNews(newsDTO));
    }
    @GetMapping()
    public ResponseEntity<List<NewsDTO>> fetchAllNews(){
        var allNews = newsService.getAllNews();
        return new ResponseEntity<>(allNews, HttpStatus.OK);
    }
}
