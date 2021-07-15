package com.example.testapplication.algorithmtest;

/**
 * Created wangjinhao on 12/24/20.
 */
class Divide2Search {


    public static void main(String[] args) {
        Divide2Search divide2Search = new Divide2Search();
        System.out.println(divide2Search.upper_bound_(5, 4, new int[]{1, 2, 3, 4, 5}));
    }

    public int upper_bound_(int n, int v, int[] a) {
        if (a[n - 1] < v) {
            return n + 1;
        }//如果不存在这样的数：即数组中所有数字都比
        int Left = 0;
        int Right = n - 1;
        while (Left < Right) {
            int Mid = Left + (Right - Left) / 2;//防溢出
            if (a[Mid] >= v) {
                Right = Mid;
            } else {
                Left = Mid + 1;
            }
        }
        return Left + 1;
    }
}
