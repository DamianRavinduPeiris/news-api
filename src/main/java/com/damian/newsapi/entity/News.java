package com.damian.newsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class News {
    @Id
    private String newsId;
    private String headLine;
    private String newsContent;
    @OneToMany(mappedBy = "news",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<NewsCategory> newsCategories;
}
