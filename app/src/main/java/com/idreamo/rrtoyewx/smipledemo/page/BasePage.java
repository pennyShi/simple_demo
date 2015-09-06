package com.idreamo.rrtoyewx.smipledemo.page;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.astuetz.PagerSlidingTabStrip;
import com.idreamo.rrtoyewx.smipledemo.R;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class BasePage extends Fragment {
    protected View mRootView;
    protected Activity mActivity;
    protected PagerSlidingTabStrip mPageTitle;
    protected ViewPager mPageContent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_page_fragment, null);
        mPageContent = (ViewPager) view.findViewById(R.id.vp_base_page_content);
        mPageTitle = (PagerSlidingTabStrip) view.findViewById(R.id.psts_base_page_title);
        mRootView = view;
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }


    public void initData(){};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = getActivity();
    }
}
