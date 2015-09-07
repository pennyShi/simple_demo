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
import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public class NewsContentPage extends BaseContentPage {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private View mEmptyView;
    public NewsContentPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = mInflater.inflate(R.layout.news_content_page,null);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_news_refresh);
        mSwipeRefreshLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mListView = (ListView) view.findViewById(R.id.lv_news_contents);
        return view;
    }

    @Override
    public void initData() {
        TextView tv = (TextView) mRootView.findViewById(R.id.tv_url);
        tv.setText(mUrl+"");
    }



}





