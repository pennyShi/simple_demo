package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public abstract class SimpleAdapter extends BaseAdapter {
    protected LayoutInflater mLayout;
    protected SparseArray<?> mlist;
    protected Context mContext;

    public SimpleAdapter(Context context,SparseArray<?> list){
        this.mContext = context;
        this.mlist = list;
        this.mLayout = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setListFromServer(SparseArray<?> list){
        if(list!=null && list.size() > 0){
            mlist = list;
            notifyDataSetChanged();
        }
    }

}
