package com.idreamo.rrtoyewx.smipledemo.page;

import android.text.TextUtils;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.idreamo.rrtoyewx.smipledemo.adapter.NewsPageContentAdapter;
import com.idreamo.rrtoyewx.smipledemo.entity.TotalNews;
import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;
import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class NewsPage extends BasePage {
    public static final String TAG = "NewsPage";
    private List<TotalNewsModel> mTotalNewsModelList;

    @Override
    public void initData() {
        RequestData();
        super.initData();
        
    }

    private void RequestData() {
        ServerApi.getTotalNews(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    parseData(response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private void parseData(String response) throws Exception {
        if(response==null && TextUtils.isEmpty(response)){
            return;
        }

        String children = response.substring(response.indexOf("\"children"), response.indexOf("]")+1);
        children = "{" + children +"}";
        TotalNews totalNews = (TotalNews) ServerApi.deserialize(children, "", TotalNews.class);
        if(totalNews!=null && totalNews.getChildren()!=null && totalNews.getChildren().size() > 0){
            mTotalNewsModelList = new ArrayList<>();
            for(Map<String, Object> map: totalNews.getChildren()){
                int type = (int) map.get(TotalNewsModel.news_type);
                if(type == 1){
                    TotalNewsModel totalNewsModel = new TotalNewsModel();
                    totalNewsModel.setValue(map);
                    mTotalNewsModelList.add(totalNewsModel);
                }

            }
        }
        mPageContent.setAdapter(new NewsPageContentAdapter(mTotalNewsModelList,mActivity));
        mPageTitle.setViewPager(mPageContent);
    }
    
}
