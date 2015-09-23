package com.idreamo.rrtoyewx.smipledemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idreamo.rrtoyewx.smipledemo.R;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class LeftMenuAdapter extends SimpleAdapter {
    public LeftMenuAdapter(Context context, SparseArray<?> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            convertView = mInflater.inflate(R.layout.item_leftmenu,null);
            holder = new ViewHolder();
            holder.leftMenu_icon = (ImageView) convertView.findViewById(R.id.item_leftmenu_icon);
            holder.leftMenu_title = (TextView) convertView.findViewById(R.id.item_leftmenu_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Object o = mlist.get(position);
        if(o instanceof Integer){
            int rsd = (Integer)o;
            holder.leftMenu_title.setText(rsd);
            switch (rsd){
                case R.string.news:
                    holder.leftMenu_icon.setImageResource(R.drawable.ic_news);
                    break;
                case R.string.music:
                    holder.leftMenu_icon.setImageResource(R.drawable.ic_music);
                    break;
                case R.string.video:
                    holder.leftMenu_icon.setImageResource(R.drawable.ic_video);
                    break;
                case R.string.photo:
                    holder.leftMenu_icon.setImageResource(R.drawable.ic_picture);
                    break;
                default:
                    break;
            }
        }


        return convertView;
    }
    class ViewHolder {
        ImageView leftMenu_icon;
        TextView leftMenu_title;
    }
}
