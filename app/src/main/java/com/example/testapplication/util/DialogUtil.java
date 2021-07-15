package com.example.testapplication.util;

import android.widget.Toast;

import com.example.testapplication.BaseApplication;

/**
 * Created wangjinhao on 2021/7/15.
 */
public class DialogUtil {


    public static void showToast(String content) {
        Toast toast = Toast.makeText(BaseApplication.getApplication(), content, Toast.LENGTH_SHORT);
        toast.show();
    }
}
