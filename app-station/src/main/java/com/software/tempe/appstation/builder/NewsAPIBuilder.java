package com.software.tempe.appstation.builder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
@Configuration
public class NewsAPIBuilder {

    private final String BASE_URL = "https://newsapi.org";
    private final String API_KEY = "api_key_here";

    public WebClient buildNewsApi() {
        return WebClient.create(BASE_URL);
    }

    public String getApiKey()   {
        return API_KEY;
    }

}
