package com.idreamo.rrtoyewx.smipledemo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/8/25.
 */
public class TotalNewsModel {
    public static final String news_id = "id";
    public static final String news_title = "title";
    public static final String news_type = "type";
    public static final String news_url = "url";

    private Map<String,Object> value = new HashMap<>();

    public Map<String,Object> getValue(){
        return value;
    }
    public void setValue(Map<String,Object> map){
        this.value = map;
    }
}
