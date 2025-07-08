package com.damian.newsapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class News {
    @Id
    private String newsId;
    private String headLine;
    private String newsContent;
    @OneToMany(mappedBy = "news")
    private List<NewsCategory> newsCategories;
}
