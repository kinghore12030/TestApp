package com.example.testapplication.algorithmtest;

import java.util.ArrayList;

/**
 * 螺旋数字
 * 题目主要是找出螺旋的规律即可,其他就是边界的判断
 * //  1 2 3    螺旋 1 2 3 6 9 8 7 4 5
 * //  4 5 6
 * //  7 8 9
 * Created wangjinhao on 12/24/20.
 */
class NumHelixTest {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            //上面  左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }

            //右边 上到下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            //下面  右到左
            for (int i = right - 1; top != bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }

            //左边 下到上
            for (int i = bottom - 1; left != right && i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }
}
