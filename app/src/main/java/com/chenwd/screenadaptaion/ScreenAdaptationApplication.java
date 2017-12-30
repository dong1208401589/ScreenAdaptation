package com.chenwd.screenadaptaion;

import android.app.Application;

/**
 * Created by Administrator on 2017/12/29.
 */

public class ScreenAdaptationApplication extends Application {
    private static ScreenAdaptationApplication instance;

    public static ScreenAdaptationApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }
}
