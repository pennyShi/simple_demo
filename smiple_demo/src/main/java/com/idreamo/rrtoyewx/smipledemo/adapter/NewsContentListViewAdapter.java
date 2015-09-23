package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.ui.NetworkImageView;
import com.idreamo.rrtoyewx.smipledemo.R;
import com.idreamo.rrtoyewx.smipledemo.entity.NewsContentModel;
import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;

import java.util.List;

/**
 * Created by rrtoyewx on 15/9/10.
 * newsContent adapter
 */
public class NewsContentListViewAdapter extends SimpleAdapter {
    public NewsContentListViewAdapter(Context context, SparseArray<?> list) {
        super(context, list);
    }

    public NewsContentListViewAdapter(Context context, List<?> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_news_content_adapter, null);
            holder = new ViewHolder();
            holder.mNewsContentAdapterIcon = (NetworkImageView) convertView.findViewById(R.id.niv_item_news_content_adapter_icon);
            holder.mNewsContentAdapterTitle = (TextView) convertView.findViewById(R.id.tv_item_news_content_adapter_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Object o = mArrayList.get(position);
        if (o instanceof NewsContentModel) {
            NewsContentModel newsContentModel = (NewsContentModel) o;
            String title = (String) newsContentModel.getValue().get(NewsContentModel.news_content_title);
            String imgUrl = (String) newsContentModel.getValue().get(NewsContentModel.news_content_listimage);

            holder.mNewsContentAdapterTitle.setText(title);
            holder.mNewsContentAdapterIcon.setDefaultImageResId(R.drawable.default_news_content_image);
            holder.mNewsContentAdapterIcon.setImageUrl(imgUrl, ServerApi.getImageLoader());
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView mNewsContentAdapterTitle;
        NetworkImageView mNewsContentAdapterIcon;
    }
}
