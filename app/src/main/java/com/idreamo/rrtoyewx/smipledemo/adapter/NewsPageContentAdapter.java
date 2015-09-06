package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;
import com.idreamo.rrtoyewx.smipledemo.page.BaseContentPage;
import com.idreamo.rrtoyewx.smipledemo.page.NewsContentPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public class NewsPageContentAdapter extends PagerAdapter {
    private Context mContext;
    private List<TotalNewsModel> mTotalNewsModelList;
    protected List<BaseContentPage> mPageList = new ArrayList<>();

    @Override
    public int getCount() {
        return mPageList.size();
    }

    public NewsPageContentAdapter(List<TotalNewsModel> totalNewsModelList,Context context) {
        this.mTotalNewsModelList = totalNewsModelList;
        mContext = context;
        for (TotalNewsModel totalNewsModel : mTotalNewsModelList) {
            NewsContentPage newsContentPage = new NewsContentPage(context);
            newsContentPage.setUrl((String) totalNewsModel.getValue().get(TotalNewsModel.news_url));
            mPageList.add(newsContentPage);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return (CharSequence) mTotalNewsModelList.get(position).getValue().get(TotalNewsModel.news_title);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NewsContentPage newsContentPage = new NewsContentPage(mContext);
        container.addView(newsContentPage.getRootView());
        return newsContentPage.getRootView();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
