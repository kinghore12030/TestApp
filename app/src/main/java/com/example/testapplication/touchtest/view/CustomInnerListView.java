package com.example.testapplication.touchtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import com.example.testapplication.util.ActionParseUtil;

/**
 * Created wangjinhao on 2021/7/15.
 */
public class CustomInnerListView extends ListView {

    public CustomInnerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //为listview/Y，设置初始值,默认为0.0(ListView条目一位置)
    private float mLastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("scrolltest","CustomInnerListView onInterceptTouchEvent "+ ActionParseUtil.parse(ev));
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                //不允许上层的ScrollView拦截事件.
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                //满足listView滑动到顶部，如果继续下滑，那就允许scrollView拦截事件
                if (getFirstVisiblePosition() == 0 && (ev.getY() - mLastY) > 0) {
                    //允许ScrollView拦截事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                //满足listView滑动到底部，如果继续上滑，允许scrollView拦截事件
                else if (getLastVisiblePosition() == getCount() - 1 && (ev.getY() - mLastY) < 0) {
                    //允许ScrollView拦截事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    //其它情形时不允ScrollView拦截事件
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        mLastY = ev.getY();
        return super.dispatchTouchEvent(ev);
    }
}