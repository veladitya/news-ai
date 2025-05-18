package com.natera.newsapi.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("News")
@Builder
public class News implements Serializable {
    @Id
    @NonNull
    private String id;
    @NonNull
    private String title;
    private String link;
    private String description;
    private String publishedDate;
    private String mediaUrl;
}
