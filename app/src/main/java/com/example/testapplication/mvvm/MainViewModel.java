package com.example.testapplication.mvvm;

import com.example.testapplication.model.Cartoon;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created wangjinhao on 2021/7/9.
 */
public class MainViewModel extends ViewModel {

    private MutableLiveData mMutableLiveData = new MutableLiveData();


    public MutableLiveData getMutableLiveData() {
        return mMutableLiveData;
    }

    public void getData(){
        Cartoon cartoon = new Cartoon();
        cartoon.setFeature("zyb");
        cartoon.setLeader("zyb");
        cartoon.setName("zyb");
        cartoon.setSeries("zyb");
        mMutableLiveData.setValue(cartoon);
    }

}
