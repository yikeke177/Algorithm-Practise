package com.yike.algorithms.leetcode.order54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jyk
 * @description: 54. 螺旋矩阵
 * @date: 2025/9/12 16:17
 * @version: 1.0
 */
public class Code54 {

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            /**
             * 自己一开始的做法是一层层打印，但边界问题太复杂
             * 于是看了一个题解，非常清晰：https://leetcode.cn/problems/spiral-matrix/solutions/2362055/54-luo-xuan-ju-zhen-mo-ni-qing-xi-tu-jie-juvi
             * 分为上右下左四个边界，每次都调整一下边界
             */
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> ans = new ArrayList<>();

            // 上边界 下边界 左边界 右边届
            int t = 0, b = m-1, l = 0, r = n-1;

            while(true){
                // 上 从左到右
                for(int j = l; j <= r;j ++){
                    ans.add(matrix[t][j]);
                }
                // 上边界更新
                t ++;
                if(t > b) break;

                // 右 从上到下
                for(int i = t; i <= b;i ++){
                    ans.add(matrix[i][r]);
                }
                // 右边界更新
                r --;
                if(l > r) break;

                // 下 从右到左
                for(int j = r;j >= l;j --){
                    ans.add(matrix[b][j]);
                }
                // 下边界更新
                b --;
                if(t > b) break;


                // 左 从下到上
                for(int i = b;i >= t;i --){
                    ans.add(matrix[i][l]);
                }
                // 左边界更新
                l ++;
                if(l > r) break;


            }
            return ans;


        }
    }
}
