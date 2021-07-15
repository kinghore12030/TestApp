package com.example.testapplication.touchtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.testapplication.util.ActionParseUtil;

/**
 * Created wangjinhao on 2021/7/14.
 */
public class LeftView extends ViewGroup {

    public LeftView(Context context) {
        this(context, null);
    }

    public LeftView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("movetest","LeftButton-dispatchTouchEvent]event="+ ActionParseUtil.parse(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i("movetest","LeftButton-onTouchEvent]event="+ActionParseUtil.parse(ev));
        return super.onTouchEvent(ev);
    }
}
