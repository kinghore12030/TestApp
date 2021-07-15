package com.example.testapplication.handlertest;

import android.os.MessageQueue;

import com.example.testapplication.LogUtil;
import com.example.testapplication.util.DialogUtil;

/**
 * Created wangjinhao on 2021/7/15.
 */
public class CustomIdleHandler implements MessageQueue.IdleHandler {

    private static final String TAG = "TAG_CustomIdleHandler";

    @Override
    public boolean queueIdle() {
        DialogUtil.showToast("走了idleHandler");
        // return false 会从消息队列中移除
        LogUtil.d(TAG,"queueIdle");
        return false;
    }
}
