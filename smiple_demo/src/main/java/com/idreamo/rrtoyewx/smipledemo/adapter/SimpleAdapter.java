package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public abstract class SimpleAdapter extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected SparseArray<?> mlist;
    protected Context mContext;
    protected List<?> mArrayList;

    public SimpleAdapter(Context context, SparseArray<?> list) {
        this.mContext = context;
        this.mlist = list;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public SimpleAdapter(Context context, List<?> list) {
        this.mContext = context;
        this.mArrayList = list;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mlist == null ? mArrayList.size() : mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist == null ? mArrayList.get(position) : mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void setListFromServer(SparseArray<?> list) {
        if (list != null && list.size() > 0) {
            mlist = list;
            notifyDataSetChanged();
        }
    }

    public void setListFromServer(List<?> list) {
        if (list != null && list.size() > 0) {
            mArrayList = list;
            notifyDataSetChanged();
        }
    }

}
