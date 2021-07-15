package com.example.testapplication.algorithmtest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created wangjinhao on 4/7/21.
 */
class FutureTaskTest implements Callable<String> {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(new FutureTaskTest());
        new Thread(task, "有返回值的线程").start();
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String call() {
        return "wangjinhao";
    }
}
