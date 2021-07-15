package com.example.testapplication.mvpapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.testapplication.R;

import androidx.appcompat.app.AppCompatActivity;


public class LoginSuccessActivity extends AppCompatActivity {

    public static Intent createIntent(Context context){
        Intent intent = new Intent(context,LoginSuccessActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
    }
}