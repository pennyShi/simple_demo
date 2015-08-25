package com.idreamo.rrtoyewx.smipledemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import java.text.SimpleDateFormat;
import java.util.Date;


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
                //overridePendingTransition(R.anim.right_enter_trans,R.anim.left_exit_trans);
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

}
