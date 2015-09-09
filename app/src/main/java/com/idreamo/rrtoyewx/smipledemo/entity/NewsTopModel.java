package com.idreamo.rrtoyewx.smipledemo.entity;

import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/9.
 *
 * id": 143861,
 "title": "南少林武僧创“水上漂”125米纪录",
 "topimage": "http://zhbj.qianlong.com/static/images/2015/09/09/7/2420813013XY5.jpg",
 "url": "http://zhbj.qianlong.com/static/html/2015/09/09/774A6C524C6D1E776C217A46.html",
 "pubdate": "2015-09-09 13:58",
 "comment": true,
 "commenturl": "http://zhbj.qianlong.com/client/user/newComment/143861",
 "type": "news",
 "commentlist": "http://zhbj.qianlong.com/static/api/news/10006/61/143861/comment_1.json"
 */
public class NewsTopModel {
    public static final String top_news_id = "id";
    public static final String top_news_title = "title";
    public static final String top_news_topimage = "topimage";
    public static final String top_news_url = "url";
    public static final String top_news_pubdate = "pubdate";
    public static final String top_news_comment = "comment";
    public static final String top_news_commenturl = "commenturl";
    public static final String top_news_type = "type";
    public static final String top_news_commentlist = "commentlist";

    private Map<String,Object> value;


    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }
}
