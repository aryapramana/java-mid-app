package com.software.tempe.appstation.service;

import com.software.tempe.appstation.model.News;
import com.software.tempe.appstation.model.mapping.NewsMapper;

public interface NewsService {

    // get news data headline from specific country
    News getHeadlineNews(String country, int page);

    NewsMapper getTopicNews(String topic, int page);

}
