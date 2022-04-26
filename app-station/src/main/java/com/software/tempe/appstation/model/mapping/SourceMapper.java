package com.software.tempe.appstation.model.mapping;

import com.fasterxml.jackson.annotation.JsonProperty;
import reactor.util.annotation.Nullable;

public class SourceMapper {
    @Nullable
    @JsonProperty("news_id")
    private String news_id;

    @JsonProperty("source_name")
    private String source_name;

    @Nullable
    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(@Nullable String news_id) {
        if (news_id == null)    {
            news_id = "";
        }
        this.news_id = news_id;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }
}
