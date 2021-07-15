package com.example.testapplication;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created wangjinhao on 11/25/20.
 */
class utils {

    //    public static void main(String args[]) {
//                int[] a = new int[1];
//        int[] b = new int[]{2, 1};
//        int[] c = {1, 2, 3, 4, 5, 6};
//        Arrays.asList(c).contains(1);
//        //此时的数组并不是一个等列数组
////        int data[][] = new int[][] {
////                {1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
////        //如果在进行输出的时候一定要使用双重循环，
////        //外部的循环控制输出的行数，而内部的循环控制输出列数
////        for(int i = 0; i < data.length; i++) {
////            for(int j = 0; j < data[i].length; j++) {
////                System.out.print("data[" + i + "][" + j + "]=" + data[i][j] + "、");
////            }
////            System.out.println();
////        }
//    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = new Callable() {

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable() {

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000 * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间：" + (end - start));
    }


}
