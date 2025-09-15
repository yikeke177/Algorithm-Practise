package com.yike.algorithms.leetcode.order1266;

/**
 * @author: jyk
 * @description: 1266. 访问所有点的最小时间
 * @date: 2025/9/12 15:51
 * @version: 1.0
 */
public class Code1266 {
    class Solution {
        public int minTimeToVisitAllPoints(int[][] points) {
            /**
             * 一定要自己画图观察！
             * 以示例1为例，根据观察可以发现，从第一个点到第二个点所花费的时间等于所构成的
             * 直角三角形的直角边的长边。
             * 因为如果是45度角的三角形，可以直接沿着对角线走过去。
             * 如果不是，则先走一个45度角三角形，再走一个水平或垂直单位，就是等于长边长度
             */

            int times = 0;
            int n = points.length;
            for(int i = 0;i < n-1;i ++){
                int a = Math.abs(points[i][0] - points[i+1][0]);
                int b =  Math.abs(points[i][1] - points[i+1][1]);
                times += Math.max(a, b);
            }
            return times;
        }
    }
}
