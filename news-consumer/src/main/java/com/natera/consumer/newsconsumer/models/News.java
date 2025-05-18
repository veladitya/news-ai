package com.natera.consumer.newsconsumer.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash(value = "News", timeToLive = 3600 * 24)
@Builder
@Jacksonized
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
