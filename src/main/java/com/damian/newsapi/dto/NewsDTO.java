package com.damian.newsapi.dto;

import com.damian.newsapi.entity.NewsCategory;

import java.io.Serializable;

public record NewsDTO(
    String headLine,
    String newsContent,
    NewsCategory[] newsCategories
) implements Serializable {
}
