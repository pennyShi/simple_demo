package com.idreamo.rrtoyewx.smipledemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 新闻主页的json
 * Created by rrtoyewx on 15/8/21.
 */
public class TotalNews implements Serializable {
    @JsonProperty("retcode")
    private TotalNewsData retcode = new TotalNewsData();

    public class TotalNewsData{
        @JsonProperty("data")
        private List<Map<String, Object>> data = new ArrayList<>();

        public List<Map<String, Object>> getData() {
            return data;
        }
    }
}
