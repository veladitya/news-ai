package com.natera.newsapi.service;

import com.natera.newsapi.models.News;
import com.natera.newsapi.respoistory.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Page<News> getAllNews(int page, int size, List<String> sortFields, List<String> directions) {
        // Constructing Sort object dynamically based on multiple fields and directions
        Sort sort = Sort.unsorted();
        for (int i = 0; i < sortFields.size(); i++) {
            Sort.Direction dir = directions.get(i).equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
            sort = sort.and(Sort.by(dir, sortFields.get(i)));
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return newsRepository.findAll(pageRequest);
    }
}

