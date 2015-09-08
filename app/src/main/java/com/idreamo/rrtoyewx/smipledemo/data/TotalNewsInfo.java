package com.idreamo.rrtoyewx.smipledemo.data;

import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/7.
 */
@DatabaseTable(tableName = "TotalNewsInfo")
public class TotalNewsInfo {
    @DatabaseField(id = true, unique = true, index = true)
    private int _id;
    @DatabaseField
    private String _title;
    @DatabaseField
    private int _type;
    @DatabaseField
    private String _url;

    public static TotalNewsInfo createNewsTotalModel(TotalNewsModel model){
        String url = (String) model.getValue().get(TotalNewsModel.news_url);
        String title = (String) model.getValue().get(TotalNewsModel.news_title);
        int id = (int) model.getValue().get(TotalNewsModel.news_id);
        int type = (int) model.getValue().get(TotalNewsModel.news_type);
        TotalNewsInfo toaTotalNewsInfo = new TotalNewsInfo(id,title,type,url);
        return toaTotalNewsInfo;

    }
    public TotalNewsInfo(int id,String title,int type,String url){
        this._id = id;
        this._title = title;
        this._type = type;
        this._url = url;
    }
    public TotalNewsInfo(){}

    public TotalNewsModel getTotalNewsModel(){
        TotalNewsModel totalNewsModel = new TotalNewsModel();
        Map<String ,Object>map = new HashMap<>();
        map.put(TotalNewsModel.news_id,_id);
        map.put(TotalNewsModel.news_url,_url);
        map.put(TotalNewsModel.news_title,_title);
        map.put(TotalNewsModel.news_type,_type);
        totalNewsModel.setValue(map);
        return totalNewsModel;
    }


    public int get_id() {
        return _id;
    }

    public String get_title() {
        return _title;
    }

    public int get_type() {
        return _type;
    }

    public String get_url() {
        return _url;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_type(int _type) {
        this._type = _type;
    }

    public void set_url(String _url) {
        this._url = _url;
    }
}
