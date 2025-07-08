package com.damian.newsapi.entity;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String newsId;
    private String headLine;
    private String newsContent;
    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "news")
    private List<NewsCategory> newsCategories;
}
