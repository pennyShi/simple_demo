package com.idreamo.rrtoyewx.smipledemo.page;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class NewsPage extends BasePage {
    @Override
    public View initView() {
        TextView tv = new TextView(mActivity);
        tv.setText("12312");
        tv.setTextColor(Color.RED);
        return tv;
    }
}
