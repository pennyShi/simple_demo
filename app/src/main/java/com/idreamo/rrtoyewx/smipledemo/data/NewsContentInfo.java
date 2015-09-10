package com.idreamo.rrtoyewx.smipledemo.data;

import com.idreamo.rrtoyewx.smipledemo.entity.NewsContent;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsContentModel;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsTopModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/10.
 *
 */
@DatabaseTable(tableName = "NewsContentInfo")
public class NewsContentInfo {
    @DatabaseField(id = true, unique = true, index = true)
    private int _id;
    @DatabaseField
    private String _title;
    @DatabaseField
    private String _url;
    @DatabaseField
    private String _listimage;
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


    public NewsContentInfo() {
    }

    public NewsContentInfo(boolean _comment, String _commentlist, String _commenturl, int _id, String _listimage, String _pubdata, String _title, String _type) {
        this._comment = _comment;
        this._commentlist = _commentlist;
        this._commenturl = _commenturl;
        this._id = _id;
        this._listimage = _listimage;
        this._pubdate = _pubdata;
        this._title = _title;
        this._type = _type;
    }

    public NewsContentInfo(String url, boolean _comment, String _commentlist, String _commenturl, int _id, String _listimage, String _pubdata, String _title, String _type) {
        this._url = url;
        this._comment = _comment;
        this._commentlist = _commentlist;
        this._commenturl = _commenturl;
        this._id = _id;
        this._listimage = _listimage;
        this._pubdate = _pubdata;
        this._title = _title;
        this._type = _type;
    }
    public static NewsContentInfo createNewsContentInfo(NewsContentModel model){
        Map<String, Object> value = model.getValue();

        int id = (int) value.get(NewsContentModel.news_content_id);
        String url = (String) value.get(NewsContentModel.news_content_url);
        boolean comment = (boolean) value.get(NewsContentModel.news_content_comment);

        String commentlist = (String) value.get(NewsContentModel.news_content_commentlist);
        String commenturl = (String) value.get(NewsContentModel.news_content_commenturl);
        String listimage = (String) value.get(NewsContentModel.news_content_listimage);

        String pubdate = (String) value.get(NewsContentModel.news_content_pubdate);
        String title = (String) value.get(NewsContentModel.news_content_title);
        String type = (String) value.get(NewsContentModel.news_content_type);
        return new NewsContentInfo(url,comment,commentlist,commenturl,id,listimage,pubdate,title,type);
    }
    public NewsContentModel getNewsContentModel(){
        Map<String,Object>value = new HashMap<>();
        value.put(NewsContentModel.news_content_id,_id);
        value.put(NewsContentModel.news_content_title,_title);
        value.put(NewsContentModel.news_content_type,_type);

        value.put(NewsContentModel.news_content_pubdate,_pubdate);
        value.put(NewsContentModel.news_content_comment,_comment);
        value.put(NewsContentModel.news_content_commentlist,_commentlist);

        value.put(NewsContentModel.news_content_commenturl,_commenturl);
        value.put(NewsContentModel.news_content_listimage, _listimage);
        value.put(NewsContentModel.news_content_url, _url);
        NewsContentModel model = new NewsContentModel();
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

    public String get_listimage() {
        return _listimage;
    }

    public void set_listimage(String _listimage) {
        this._listimage = _listimage;
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
