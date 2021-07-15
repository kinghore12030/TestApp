package com.example.testapplication;

import android.util.Printer;


/**
 * Created wangjinhao on 2021/7/6.
 */
class PrinterTest implements Printer {

    private boolean isStart;
    private long mStart;

    /**
     * Write a line of text to the output.  There is no need to terminate
     * the given string with a newline.
     *
     * @param x
     */
    @Override
    public void println(String x) {
        if (x.contains("Dispatching")) {
            mStart = System.currentTimeMillis();
        } else {
            long dur = System.currentTimeMillis() - mStart;
            if (dur > 16) {
                LogUtil.d("LoopPrint", x);
                LogUtil.d("LoopPrint", "卡顿了");
                LogUtil.d("LoopPrint", "耗时："+String.valueOf(dur));
                LogUtil.d("LoopPrint", BaseApplication.getApplication().getTraces(System.currentTimeMillis()) + "\n");
            }
        }
    }
}
