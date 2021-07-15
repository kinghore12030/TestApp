package com.example.testapplication;

import android.app.Application;
import android.os.Looper;

/**
 * Created wangjinhao on 2021/7/7.
 */
public class BaseApplication extends Application {

    private  ThreadStackTraces threadStackTraces;
    private static BaseApplication mApplication;

    private void initProcessInfo() {
        threadStackTraces = new ThreadStackTraces();
        threadStackTraces.start();
    }

    public String getTraces(long time){
        return threadStackTraces.getTraces(time);
    }

    public static BaseApplication getApplication() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
//        Looper.getMainLooper().setMessageLogging(new PrinterTest());
//        initProcessInfo();
    }
}
