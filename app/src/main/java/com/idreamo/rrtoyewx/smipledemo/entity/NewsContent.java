package com.idreamo.rrtoyewx.smipledemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 新闻详情的json
 * Created by rrtoyewx on 15/9/9.
 */
public class NewsContent implements Serializable {
    @JsonProperty("data")
    private NewsContentData data = new NewsContentData();

    public NewsContentData getData() {
        return data;
    }


    public class NewsContentData {
        @JsonProperty("topnews")
        private List<Map<String, Object>> topnews = new ArrayList<>();

        public List<Map<String, Object>> getTopNews() {
            return topnews;
        }

        @JsonProperty("news")
        private List<Map<String, Object>> news = new ArrayList<>();

        public List<Map<String, Object>> getNews() {
            return news;
        }
    }
}

