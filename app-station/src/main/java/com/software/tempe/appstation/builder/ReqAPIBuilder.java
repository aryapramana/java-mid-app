package com.software.tempe.appstation.builder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
@Component
public class ReqAPIBuilder {
    private final String BASE_URL = "https://reqres.in";

    public WebClient buildReqAPI() {
        return WebClient.create(BASE_URL);
    }

}
