package com.example.testapplication.mvvm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.testapplication.R;
import com.example.testapplication.databinding.ActivityMvvmBinding;
import com.example.testapplication.model.Cartoon;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

/**
 * Created wangjinhao on 2021/7/14.
 */
public class MvvmActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMvvmBinding mActivityMvvmBinding;
    private Cartoon cartoon = new Cartoon();
    private MainViewModel viewModel;

    public static void open(Context context) {
        context.startActivity(new Intent(context, MvvmActivity.class));
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mActivityMvvmBinding.setCartoon(cartoon);
        viewModel = new MainViewModel();
        initListener();
    }

    private void initListener() {
        mActivityMvvmBinding.btnChange.setOnClickListener(this);
        viewModel.getMutableLiveData().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                if (o instanceof Cartoon) {
                    mActivityMvvmBinding.setCartoon((Cartoon) o);
                }
            }
        });
    }

    private void getData() {
        viewModel.getData();
    }

    @Override
    public void onClick(View v) {
        if (v == mActivityMvvmBinding.btnChange) {
            getData();
        }
    }
}
