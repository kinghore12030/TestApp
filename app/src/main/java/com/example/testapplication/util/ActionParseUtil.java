package com.example.testapplication.util;

import android.view.MotionEvent;

/**
 * Created wangjinhao on 2021/7/14.
 */
public class ActionParseUtil {

    public static String parse(MotionEvent ev){
        String result = "";
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                result = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                result = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                result = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                result = "ACTION_CANCEL";
                break;
        }
        return result + " x "+ev.getX() +" y "+ev.getY();
    }
}
