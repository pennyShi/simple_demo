package com.idreamo.rrtoyewx.smipledemo.page;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.idreamo.rrtoyewx.smipledemo.R;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsContent;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsContentModel;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsTopModel;
import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public class NewsContentPage extends BaseContentPage {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private View mEmptyView;
    private List<NewsTopModel> mTopNewsList = new ArrayList<>();
    private List<NewsContentModel> mNewsContentModelList = new ArrayList<>();



    public NewsContentPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = mInflater.inflate(R.layout.news_content_page, null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_news_refresh);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mListView = (ListView) view.findViewById(R.id.lv_news_contents);
        return view;
    }

    @Override
    public void initData() {

        bind();
    }

    private void bind() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ServerApi.getDetailsNews(mUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseDataAndLoadDB(response);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
            }
        });
    }

    private void parseDataAndLoadDB(String response) {
        try {
            NewsContent newsContent = (NewsContent) ServerApi.deserialize(response, "", NewsContent.class);
            if (newsContent != null && newsContent.getData() != null
                    && newsContent.getData().getNews() != null && newsContent.getData().getNews().size() > 0
                    && newsContent.getData().getTopNews() != null && newsContent.getData().getTopNews().size() > 0) {
                for(Map<String ,Object> map : newsContent.getData().getTopNews()){
                    NewsTopModel newsTopModel = new NewsTopModel();
                    newsTopModel.setValue(map);
                    mTopNewsList.add(newsTopModel);
                }
                for(Map<String,Object> map :newsContent.getData().getNews()){
                    NewsContentModel newsContentModel = new NewsContentModel();
                    newsContentModel.setValue(map);
                    mNewsContentModelList.add(newsContentModel);
                }

            }
            newsContent.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}




