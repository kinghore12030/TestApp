package com.example.testapplication.touchtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created wangjinhao on 2021/7/15.
 */
public class CustomInnerScrollView extends ScrollView {

    public CustomInnerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
