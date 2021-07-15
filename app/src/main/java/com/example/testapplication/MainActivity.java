package com.example.testapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testapplication.camera.CameraMainctivity;
import com.example.testapplication.camera.camera1.CameraActivity;
import com.example.testapplication.handlertest.CustomIdleHandler;
import com.example.testapplication.mvpapplication.LoginMvpActivity;
import com.example.testapplication.mvvm.MvvmActivity;
import com.example.testapplication.touchtest.TouchTestMainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnCamera;
    private Button mBtnTouchTest;
    private Button mBtnMvvmTest;
    private Button mBtnMvpTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        CustomIdleHandler idleHandler = new CustomIdleHandler();
        Looper.myQueue().addIdleHandler(idleHandler);
//        Looper.myQueue().removeIdleHandler(idleHandler);
    }

    private void initView() {
        mBtnCamera = findViewById(R.id.btn_open_camera);
        mBtnTouchTest = findViewById(R.id.btn_touch_test);
        mBtnMvvmTest = findViewById(R.id.btn_mvvm_test);
        mBtnMvpTest = findViewById(R.id.btn_mvp_test);
    }

    private void initListener() {
        mBtnCamera.setOnClickListener(this);
        mBtnTouchTest.setOnClickListener(this);
        mBtnMvvmTest.setOnClickListener(this);
        mBtnMvpTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_camera:
                checkPermission();
                break;
            case R.id.btn_touch_test:
                goTouchTest();
                break;
            case R.id.btn_mvvm_test:
                goMvvmTest();
                break;
            case R.id.btn_mvp_test:
                goMvpTest();
                break;
        }
    }

    private void goMvvmTest() {
        MvvmActivity.open(this);
    }

    private void goMvpTest() {
        LoginMvpActivity.open(this);
    }

    private void goTouchTest() {
        TouchTestMainActivity.Companion.open(this);
    }


    //打开相机
    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            //Toast.makeText(MainActivity.this,"您申请了动态权限",Toast.LENGTH_SHORT).show();
            CameraMainctivity.Companion.open(this);
        } else {
            //否则去请求相机权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100: {
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 申请成功，进行相应操作
                    startActivity(CameraActivity.createIntent(this));
                } else {
                    // 申请失败，可以继续向用户解释。
                    showToast("没有相机权限,您可能无法使用相机");
                }
                return;
            }
        }
    }

    private void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}