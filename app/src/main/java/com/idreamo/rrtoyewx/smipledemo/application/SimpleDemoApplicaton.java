package com.idreamo.rrtoyewx.smipledemo.application;

import android.app.Application;

import com.idreamo.rrtoyewx.smipledemo.network.ServerApi;

/**
 * Created by rrtoyewx on 15/8/21.
 */
public class SimpleDemoApplicaton extends Application {
    private SimpleDemoApplicaton mSimpleDemoApplicaton;

    @Override
    public void onCreate() {
        super.onCreate();
        mSimpleDemoApplicaton = this;
        ServerApi.init(this);

    }
}
