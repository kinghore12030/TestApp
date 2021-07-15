package com.example.testapplication.mvpapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.example.testapplication.R;
import com.example.testapplication.mvpapplication.present.LoginPresenter;
import com.example.testapplication.mvpapplication.view.LoginView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginMvpActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private LoginPresenter mLoginPresenter;
    private Button button;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private ProgressBar mProgressBar;
    private static Handler mHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    public static void open(Context context){
        context.startActivity(new Intent(context,LoginMvpActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_main);
        initPresenter();
        initView();
        initListener();
    }

    private void initPresenter() {
        mLoginPresenter = new LoginPresenter(this,mHandler);
    }

    private void initView() {
        button = findViewById(R.id.btn_login);
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mProgressBar = findViewById(R.id.progress);
    }

    private void initListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String userName = mEtUsername.getText().toString().trim();
        String passWord = mEtPassword.getText().toString().trim();
        mLoginPresenter.login(userName, passWord);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }

    @Override
    public void onLoginProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginFailed() {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        startActivity(LoginSuccessActivity.createIntent(this));
    }
}