package com.example.testapplication;

import android.os.Looper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created wangjinhao on 2021/7/6.
 */
public class ThreadStackTraces extends Thread {

    private Map<Long, String> mMap = new HashMap<>();

    @Override
    public void run() {
        while (true) {
            StringBuilder stringBuilder = null;
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread thread = entry.getKey();

                StackTraceElement[] stackTraceElements = entry.getValue();

                if (!thread.equals(Looper.getMainLooper().getThread())) {
                    continue;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("\n线程： " + thread.getName() + "\n");

                for (StackTraceElement element : stackTraceElements) {
                    stringBuilder.append("\t" + element + "\n");
                }
            }
            if (mMap.size() > 100) {
                mMap.clear();
            }
            mMap.put(System.currentTimeMillis(), stringBuilder.toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public Map<Long, String> getMap() {
        return mMap;
    }

    public String getTraces(long time) {
        long nearTime = 0;

        for (long keyTime : mMap.keySet()) {
            if (keyTime <= time && keyTime >= nearTime) {
                nearTime = keyTime;
            }
        }
        String traces = mMap.get(nearTime);
        return traces;
    }
}
