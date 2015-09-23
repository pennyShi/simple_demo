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

import jazzyviewpager.JazzyViewPager;
import jazzyviewpager.OutlineContainer;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public class NewsPageContentAdapter extends PagerAdapter {
    private Context mContext;
    private List<TotalNewsModel> mTotalNewsModelList;
    private List<BaseContentPage> mPageList;
    private JazzyViewPager mJazzyViewPager;



    @Override
    public int getCount() {
        return mTotalNewsModelList.size();
    }

    public NewsPageContentAdapter(JazzyViewPager JazzyViewPager,List<TotalNewsModel> totalNewsModelList,List<BaseContentPage> list,Context context) {
        this.mTotalNewsModelList = totalNewsModelList;
        mContext = context;
        mPageList =  list;
        mJazzyViewPager = JazzyViewPager;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) mTotalNewsModelList.get(position).getValue().get(TotalNewsModel.news_title);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NewsContentPage page = (NewsContentPage) mPageList.get(position);
        page.setmRootView();
        container.addView(page.getRootView());
        if(position==0){
            page.initData();

        }
        View rootView = page.getRootView();
        mJazzyViewPager.setObjectForPosition(rootView, position);
        return rootView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (view instanceof OutlineContainer) {
            return ((OutlineContainer) view).getChildAt(0) == object;
        } else {
            return view == object;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mJazzyViewPager.findViewFromObject(position));
    }

}
