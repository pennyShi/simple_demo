package com.idreamo.rrtoyewx.smipledemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.idreamo.rrtoyewx.smipledemo.adapter.NewsPageContentAdapter;
import com.idreamo.rrtoyewx.smipledemo.data.LocalDataHelper;
import com.idreamo.rrtoyewx.smipledemo.data.TotalNewsInfo;
import com.idreamo.rrtoyewx.smipledemo.entity.TotalNews;
import com.idreamo.rrtoyewx.smipledemo.entity.TotalNewsModel;
import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;
import com.j256.ormlite.table.TableUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class WelcomeActivity extends AppCompatActivity {
    private FrameLayout mWelcomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        initView();
        setBackGround();
        bind();
        requestTotalNews();
    }

    private void bind() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        mWelcomePage.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                MainActivity.start(WelcomeActivity.this);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void setBackGround() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date curDate = new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        int hour = Integer.parseInt(str);
        if(hour > 12 && hour <= 18){
            mWelcomePage.setBackgroundResource(R.drawable.afternoon);
        }else if(hour > 6 && hour <= 12){
            mWelcomePage.setBackgroundResource(R.drawable.morning);
        }else{
            mWelcomePage.setBackgroundResource(R.drawable.night);
        }
    }

    private void initView() {
        mWelcomePage = (FrameLayout) this.findViewById(R.id.welcome_page_graphics);
    }
    private static void requestTotalNews(){
        ServerApi.getTotalNews(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    parseDataAndLoadDB(response);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
    private static void  parseDataAndLoadDB(String response) throws Exception {
        if(response==null && TextUtils.isEmpty(response)){
            return;
        }

        String children = response.substring(response.indexOf("\"children"), response.indexOf("]")+1);
        children = "{" + children +"}";
        TotalNews totalNews = (TotalNews) ServerApi.deserialize(children, "", TotalNews.class);
        if(totalNews!=null && totalNews.getChildren()!=null && totalNews.getChildren().size() > 0){
            List<TotalNewsModel> totalNewsModels = new ArrayList<>();
            for(Map<String, Object> map: totalNews.getChildren()){
                int type = (int) map.get(TotalNewsModel.news_type);
                if(type == 1){
                    TotalNewsModel totalNewsModel = new TotalNewsModel();
                    totalNewsModel.setValue(map);
                    totalNewsModels.add(totalNewsModel);
                }
            }
            if(totalNewsModels.size() > 0 ){
                TableUtils.clearTable(LocalDataHelper.getLocalDataHelper().getConnectionSource(), TotalNewsInfo.class);
            }
            for(TotalNewsModel model:totalNewsModels){
                TotalNewsInfo totalNewsInfo = TotalNewsInfo.createNewsTotalModel(model);
                LocalDataHelper.getLocalDataHelper().getTotalNewsInfoDAO().createIfNotExists(totalNewsInfo);
            }
        }
    }
}
