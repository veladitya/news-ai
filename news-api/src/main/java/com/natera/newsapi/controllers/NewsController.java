package com.natera.newsapi.controllers;

import com.natera.newsapi.models.News;
import com.natera.newsapi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // Allows requests from any origin
@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public Page<News> getAllNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "publishedDate") List<String> sort,
            @RequestParam(defaultValue = "asc") List<String> direction) {

        return newsService.getAllNews(page, size, sort, direction);
    }
}

