package com.idreamo.rrtoyewx.smipledemo.page;

import android.support.v4.view.ViewPager;

import com.idreamo.rrtoyewx.smipledemo.adapter.NewsPageContentAdapter;
import com.idreamo.rrtoyewx.smipledemo.data.LocalDataHelper;
import com.idreamo.rrtoyewx.smipledemo.data.TotalNewsInfo;
import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import jazzyviewpager.JazzyViewPager;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class NewsPage extends BasePage {
    public static final String TAG = "NewsPage";
    private List<TotalNewsModel> mTotalNewsModelList;
    private NewsPageContentAdapter mNewsPageContentAdapter;
    private List<BaseContentPage> mPageList;


    @Override
    protected void initData() {
        super.initData();
        loadData();
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    private void loadData() {
        mTotalNewsModelList =  getTotalNewsInfos();
        mPageList = new ArrayList<>();
        int size = mTotalNewsModelList.size();
        for(int i = 0;i < size;i++){
            NewsContentPage page = new NewsContentPage(mActivity);
            page.setUrl((String) mTotalNewsModelList.get(i).getValue().get(TotalNewsModel.news_url));
            mPageList.add(page);
        }
        mNewsPageContentAdapter =  new NewsPageContentAdapter(mJazzyViewPager,mTotalNewsModelList,mPageList,mActivity);
        mJazzyViewPager.setAdapter(mNewsPageContentAdapter);
        mPageTitle.setViewPager(mJazzyViewPager);
        bind();
    }



    private void bind() {
        mPageTitle.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showPageContent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showPageContent(int position) {
        mPageList.get(position).initData();
    }

    public List<TotalNewsModel> getTotalNewsInfos() {
        List<TotalNewsInfo> totalNewsInfos = LocalDataHelper.getLocalDataHelper().getTotalNewsInfoDAO().queryForAll();
        if(totalNewsInfos!=null && totalNewsInfos.size() > 0){
            List<TotalNewsModel> totalNewsModels = new ArrayList<>();
            for(TotalNewsInfo info :totalNewsInfos){
                TotalNewsModel totalNewsModel = info.getTotalNewsModel();
                totalNewsModels.add(totalNewsModel);
            }
            return totalNewsModels;
        }
        
        return null;
    }
}
