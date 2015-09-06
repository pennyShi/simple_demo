package com.idreamo.rrtoyewx.smipledemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 新闻主页的json
 * Created by rrtoyewx on 15/8/21.
 */
public class TotalNews implements Serializable {
    @JsonProperty("children")
    private List<Map<String, Object>> children = new ArrayList<>();

    public List<Map<String, Object>> getChildren() {
        return children;
    }
}
