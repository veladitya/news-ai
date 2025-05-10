package com.natera.newsapi.respoistory;

import com.natera.newsapi.models.News;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends CrudRepository<News, String>, PagingAndSortingRepository<News, String> {
}
