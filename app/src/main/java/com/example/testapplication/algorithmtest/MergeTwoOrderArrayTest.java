package com.example.testapplication.algorithmtest;

/**
 * 合并两个有序数组
 * Created wangjinhao on 12/25/20.
 */
class MergeTwoOrderArrayTest {
    public void merge(int A[], int m, int B[], int n) {
        int[] result = new int[m + n];
        int t = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {//两边有序数组相互比较得出小的元素依次存放
                result[t++] = A[i++];
            } else {
                result[t++] = B[j++];
            }

        }
        //将剩余元素依次存放在result数组中
        while (i < m) {//左边数组A如果还有剩余元素，全部存放在result数组中
            result[t++] = A[i++];
        }
        while (j < n) {//右边数组B如果还有剩余元素，全部存放在result数组中
            result[t++] = B[j++];
        }
        for (int sum = 0; sum < result.length; sum++) {//最后通过遍历将result数组元素存放到A数组中
            A[sum] = result[sum];
        }

    }
}
