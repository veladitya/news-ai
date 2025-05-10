package com.natera.newsapi.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("News")
@Builder
public class News implements Serializable {
    @Id
    private String id;
    private String title;
    private String link;
    private String description;
    private String publishedDate;
    private String mediaUrl;
}
