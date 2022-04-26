package com.software.tempe.appstation.controller;

import com.software.tempe.appstation.model.News;
import com.software.tempe.appstation.model.mapping.NewsMapper;
import com.software.tempe.appstation.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/news")
public class NewsController {
    // constructor dependency injection
    private final NewsService service;
    private Map<String, Object> response_body_json;
    private News news_data;
    private NewsMapper news_all;

    public NewsController(NewsService service) {
        super();
        this.service = service;
    }

    @GetMapping("/headlines")
    public Map<String, Object> getHeadlineNews(@RequestParam String country, @RequestParam int page)  {

        response_body_json = new HashMap<>();

        try {
            news_data = service.getHeadlineNews(country, page);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
            response_body_json.put("total", news_data.getArticles().size());
            response_body_json.put("data", news_data.getArticles());
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

    @GetMapping("/everything")
    public Map<String, Object> getTopicNews(@RequestParam String topic, @RequestParam int page) {
        response_body_json = new HashMap<>();

        try {
            news_all = service.getTopicNews(topic, page);
            response_body_json.put("status", HttpStatus.OK.value());
            response_body_json.put("message", HttpStatus.OK);
            response_body_json.put("total", news_all.getArticles_data().size());
            response_body_json.put("data", news_all.getArticles_data());
        } catch (Exception e)   {
            response_body_json.put("status", HttpStatus.BAD_REQUEST.value());
            response_body_json.put("message", e.getMessage());
        }

        return response_body_json;

    }

}
