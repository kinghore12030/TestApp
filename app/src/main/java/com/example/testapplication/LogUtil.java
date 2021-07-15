package com.example.testapplication;

import android.util.Log;

/**
 * 日志类 用于测试模式下输出日志
 * Created by lbc on 2018/8/23.
 */
public class LogUtil {


    public static void i(String tag, String msg) {
        if (isNotDebugMode()) {
            return;
        }
        Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isNotDebugMode()) {
            return;
        }
        Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (isNotDebugMode()) {
            return;
        }
        Log.d(tag, msg, tr);
    }

    public static void w(String tag, String msg) {
        if (isNotDebugMode()) {
            return;
        }
        Log.w(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isNotDebugMode()) {
            return;
        }
        Log.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isNotDebugMode()) {
            return;
        }
        Log.e(tag, msg);
    }

    private static boolean isNotDebugMode() {
        return !BuildConfig.DEBUG;
    }

    public static boolean isDebugMode() {
        return BuildConfig.DEBUG;
    }


}
