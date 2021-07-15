package com.example.testapplication.mvpapplication.present;

import android.os.Handler;

import com.example.testapplication.mvpapplication.model.LoginModel;
import com.example.testapplication.mvpapplication.view.LoginView;


/**
 * Created wangjinhao on 7/1/21.
 */
public class LoginPresenter {

    private LoginView mLoginView;
    private Handler mHandler;

    public LoginPresenter(LoginView loginView, Handler handler){
        this.mLoginView = loginView;
        this.mHandler = handler;
    }

    public void onDestroy(){
        mLoginView = null;
        mHandler = null;
    }

    public void login(String userName,String password){
        LoginModel mLoginModel = new LoginModel();
        mLoginView.onLoginProgress();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isLogin = mLoginModel.login(userName,password);
                if(isLogin){
                    mLoginView.onLoginSuccess();
                    return;
                }
                mLoginView.onLoginFailed();
            }
        },2000);

    }
}
