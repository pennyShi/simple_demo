package com.idreamo.rrtoyewx.smipledemo.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by rrtoyewx on 15/9/6.
 */
public abstract class BaseContentPage {
    protected View mRootView;
    protected Context mContext;
    protected String mUrl;
    protected LayoutInflater mInflater;
    public BaseContentPage(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void setmRootView(){
        mRootView = initView();
    }
    public abstract View initView();

    public void initData(){}

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public View getRootView(){
        return mRootView;
    }

}
