package com.software.tempe.appstation.model.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NewsMapper {
    @JsonProperty("status")
    private String status;

    @JsonProperty("total_results")
    private int totalResults;

    @JsonProperty("articles")
    private List<ArticleMapper> articles_data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticleMapper> getArticles_data() {
        return articles_data;
    }

    public void setArticles_data(List<ArticleMapper> articles_data) {
        this.articles_data = articles_data;
    }
}
