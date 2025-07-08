package com.damian.newsapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NewsCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String categoryId;
    private String categoryName;
    @ManyToOne
    @JoinColumn(name = "newsId")
    private News news;
}
