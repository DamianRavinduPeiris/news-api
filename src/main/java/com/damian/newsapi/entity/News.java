package com.damian.newsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class News {
    @Id
    private String newsId;
    private String headLine;
    private String newsContent;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "news_and_category",
        joinColumns = @JoinColumn(name = "news_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnore
    private List<NewsCategory> newsCategories = new ArrayList<>();
}
