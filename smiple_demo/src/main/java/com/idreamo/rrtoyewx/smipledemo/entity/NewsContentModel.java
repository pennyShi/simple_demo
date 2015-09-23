package com.idreamo.rrtoyewx.smipledemo.entity;

import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/9.
 * "id": 143823,
 "title": "大一新生报到请产假 迎新老师被吓傻",
 "url": "http://zhbj.qianlong.com/static/html/2015/09/09/724F6C52416010796F267F41.html",
 "listimage": "http://zhbj.qianlong.com/static/images/2015/09/09/40/16250257458FOI.jpg",
 "pubdate": "2015-09-09 10:19",
 "comment": true,
 "commenturl": "http://zhbj.qianlong.com/client/user/newComment/143823",
 "type": "news",
 "commentlist": "http://zhbj.qianlong.com/static/api/news/10006/23/143823/comment_1.json"
 },
 */
public class NewsContentModel {
    public static final String news_content_id = "id";
    public static final String news_content_title = "title";
    public static final String news_content_url = "url";
    public static final String news_content_listimage = "listimage";
    public static final String news_content_pubdate = "pubdate";
    public static final String news_content_comment = "comment";
    public static final String news_content_commenturl = "commenturl";
    public static final String news_content_type = "type";
    public static final String news_content_commentlist = "commentlist";

    private Map<String,Object> value;


    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }
}
