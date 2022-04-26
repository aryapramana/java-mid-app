package com.software.tempe.appstation.model.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ArticleMapper {
    @JsonProperty("news_source")
    private SourceMapper news_source;

    @JsonProperty("author")
    private String author;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("url")
    private String url;

    @JsonProperty("url_to_image")
    private String url_image;

    @JsonProperty("date_of_publish")
    private Date date_of_publish;

    @JsonProperty("content")
    private String content;

    public SourceMapper getNews_source() {
        return news_source;
    }

    public void setNews_source(SourceMapper news_source) {
        this.news_source = news_source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null) {
            author = "";
        }
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Date getDate_of_publish() {
        return date_of_publish;
    }

    public void setDate_of_publish(Date date_of_publish) {
        this.date_of_publish = date_of_publish;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
