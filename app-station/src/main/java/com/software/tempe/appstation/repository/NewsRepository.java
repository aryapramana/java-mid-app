package com.software.tempe.appstation.repository;

import com.software.tempe.appstation.builder.NewsAPIBuilder;
import lombok.Getter;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {
    @Getter
    private NewsAPIBuilder builder;

    public NewsRepository(NewsAPIBuilder builder) {
        super();
        this.builder = builder;
    }
}
