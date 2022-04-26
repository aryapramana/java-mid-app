package com.software.tempe.appstation.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.software.tempe.appstation.model.News;
import com.software.tempe.appstation.model.mapping.ArticleMapper;
import com.software.tempe.appstation.model.mapping.NewsMapper;
import com.software.tempe.appstation.model.mapping.SourceMapper;
import com.software.tempe.appstation.repository.NewsRepository;
import com.software.tempe.appstation.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NewsServiceImplementation implements NewsService   {

    private final NewsRepository repository;

    @Autowired
    public NewsServiceImplementation(NewsRepository repository) {
        this.repository = repository;
    }

    @Override
    public News getHeadlineNews(String country, int page) {
        String news_data_json = repository.getBuilder().buildNewsApi().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/top-headlines")
                        .queryParam("apiKey", repository.getBuilder().getApiKey())
                        .queryParam("country", country)
                        .queryParam("page", page)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .share()
                .block();

        // map to class
        ObjectMapper data_mapper = new ObjectMapper();
        News news_data = null;
        try {
            news_data = data_mapper.readValue(news_data_json, News.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return news_data;

    }

    @Override
    public NewsMapper getTopicNews(String topic, int page) {
        String news_topic_json = repository.getBuilder().buildNewsApi().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/everything")
                        .queryParam("q", topic)
                        .queryParam("page", page)
                        .queryParam("apiKey", repository.getBuilder().getApiKey())
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .share()
                .block();

        // map to class
        ObjectMapper topic_mapper = new ObjectMapper();
        News news_topic = null;
        try {
            news_topic = topic_mapper.readValue(news_topic_json, News.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // map to new response
        NewsMapper news_mapper = new NewsMapper();
        List<ArticleMapper> article_mapper_list = new ArrayList<>();

        news_mapper.setStatus(news_topic.getStatus());
        news_mapper.setTotalResults(news_topic.getTotalResults());

        for(int i = 0; i < news_topic.getArticles().size(); i++)    {
            ArticleMapper article_mapper = new ArticleMapper();
            SourceMapper source_mapper = new SourceMapper();

            // article news mapping
            article_mapper.setTitle(news_topic.getArticles().get(i).getTitle());
            article_mapper.setAuthor(news_topic.getArticles().get(i).getAuthor());
            article_mapper.setDate_of_publish(news_topic.getArticles().get(i).getPublishedAt());
            article_mapper.setDescription(news_topic.getArticles().get(i).getDescription());
            article_mapper.setAuthor(news_topic.getArticles().get(i).getAuthor());
            article_mapper.setUrl_image(news_topic.getArticles().get(i).getUrlToImage());
            article_mapper.setContent(news_topic.getArticles().get(i).getContent());
            article_mapper.setUrl(news_topic.getArticles().get(i).getUrl());

            // source news mapping
            source_mapper.setNews_id(news_topic.getArticles().get(i).getSource().getId());
            source_mapper.setSource_name(news_topic.getArticles().get(i).getSource().getName());

            // set to object source
            article_mapper.setNews_source(source_mapper);

            // add to list
            article_mapper_list.add(article_mapper);
        }

        news_mapper.setArticles_data(article_mapper_list);

        return news_mapper;

    }
}
