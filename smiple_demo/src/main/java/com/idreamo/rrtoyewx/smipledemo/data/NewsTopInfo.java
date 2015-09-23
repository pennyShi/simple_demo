package com.idreamo.rrtoyewx.smipledemo.data;

import com.idreamo.rrtoyewx.smipledemo.entity.NewsTopModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/10.
 */
@DatabaseTable(tableName = "NewsTopInfo")
public class NewsTopInfo {
    @DatabaseField(id = true, unique = true, index = true)
    private int _id;
    @DatabaseField
    private String _title;
    @DatabaseField
    private String _topimage;
    @DatabaseField
    private String _url;
    @DatabaseField
    private String _pubdate;
    @DatabaseField
    private boolean _comment;
    @DatabaseField
    private String _commenturl;
    @DatabaseField
    private String _type;
    @DatabaseField
    private String _commentlist;

    public NewsTopInfo(){}

    public NewsTopInfo(boolean _comment, String _commentlist, String _commenturl, int _id, String _pubdate, String _title, String _topimage, String _type, String _url) {
        this._comment = _comment;
        this._commentlist = _commentlist;
        this._commenturl = _commenturl;
        this._id = _id;
        this._pubdate = _pubdate;
        this._title = _title;
        this._topimage = _topimage;
        this._type = _type;
        this._url = _url;
    }


    public static NewsTopInfo createTopNewsInfo(NewsTopModel model){
        Map<String, Object> value = model.getValue();
        int id = (int) value.get(NewsTopModel.top_news_id);
        boolean comment = (boolean) value.get(NewsTopModel.top_news_comment);
        String commentlist = (String) value.get(NewsTopModel.top_news_commentlist);
        String commenturl = (String) value.get(NewsTopModel.top_news_commenturl);
        String pubdate = (String) value.get(NewsTopModel.top_news_pubdate);
        String title = (String) value.get(NewsTopModel.top_news_title);
        String topimage = (String) value.get(NewsTopModel.top_news_topimage);
        String type = (String) value.get(NewsTopModel.top_news_type);
        String url = (String) value.get(NewsTopModel.top_news_url);

        return new NewsTopInfo(comment,commentlist,commenturl,id,pubdate,title,topimage,type,url);
    }

    public NewsTopModel getNewsTopModel(){
        Map<String,Object> value = new HashMap<>();
        value.put(NewsTopModel.top_news_id,_id);
        value.put(NewsTopModel.top_news_pubdate,_pubdate);
        value.put(NewsTopModel.top_news_type,_type);

        value.put(NewsTopModel.top_news_commenturl,_commenturl);
        value.put(NewsTopModel.top_news_comment,_comment);
        value.put(NewsTopModel.top_news_commentlist,_commentlist);

        value.put(NewsTopModel.top_news_url,_url);
        value.put(NewsTopModel.top_news_topimage,_topimage);
        value.put(NewsTopModel.top_news_title,_title);
        NewsTopModel model = new NewsTopModel();
        model.setValue(value);
        return model;
    }

    public boolean is_comment() {
        return _comment;
    }

    public void set_comment(boolean _comment) {
        this._comment = _comment;
    }

    public String get_commentlist() {
        return _commentlist;
    }

    public void set_commentlist(String _commentlist) {
        this._commentlist = _commentlist;
    }

    public String get_commenturl() {
        return _commenturl;
    }

    public void set_commenturl(String _commenturl) {
        this._commenturl = _commenturl;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_pubdate() {
        return _pubdate;
    }

    public void set_pubdate(String _pubdate) {
        this._pubdate = _pubdate;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public String get_topimage() {
        return _topimage;
    }

    public void set_topimage(String _topimage) {
        this._topimage = _topimage;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_url() {
        return _url;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
