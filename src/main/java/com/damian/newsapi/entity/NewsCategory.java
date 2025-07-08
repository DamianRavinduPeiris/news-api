package com.damian.newsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class NewsCategory {
    @Id
    private String categoryId;
    private String categoryName;
    @ManyToMany(mappedBy = "newsCategories")
    @JsonIgnore
    private List<News> news = new ArrayList<>();
}
