package com.example.testapplication.mvpapplication.model;

import android.text.TextUtils;

/**
 * Created wangjinhao on 7/1/21.
 */
public class LoginModel {

    public boolean login(String userName,String passWord){
        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)){
            return false;
        }
        if(userName.equals("wang") && passWord.equals("guo")){
            return true;
        }
        return false;
    }
}
