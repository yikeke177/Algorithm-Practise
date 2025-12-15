package com.yike.algorithms.leetcode.order51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jyk
 * @description: 51. N 皇后
 * @date: 2025/12/14 10:11
 * @version: 1.0
 */
public class Code51 {

    /*
    n皇后本质上就是一个全排列问题，如何抽象和理解呢？
    普通的全排列给定数字`[1, 2, 3]`，得到所有全排列，相当于每个位置选一个没选过的数。

    对于n=4皇后问题来说，由于每行只能选择没选过的一列，相当于给定列数`[0, 1, 2, 3]`，每一行选择其中没选过的一列。也是全排列问题。
    但n皇后还有“不能同一斜线”的要求。那么就判断左上角和右上角是否有皇后，有就跳过这种选择。
     */
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String >> ans = new ArrayList<>();
            // 存每一种结果，也就是每一行选择了哪一列
            int[] cols = new int[n];

            boolean[] selected = new boolean[n];
            dfs(0, n, cols, selected, ans);

            return ans;
        }


        private void dfs(int row, int n, int[] cols, boolean[] selected, List<List<String >> ans){
            // 递归退出条件
            if(row == n){
                List<String> res = new ArrayList<>();
                for(int c : cols){
                    // 构建一种n皇后结果
                    char[] chars = new char[n];
                    // 先填充'.'
                    Arrays.fill(chars, '.');
                    chars[c] = 'Q';
                    res.add(new String(chars));
                }
                ans.add(res);
                return;
            }


            // 选择哪一列
            for(int i = 0;i < n;i ++){
                // 是否已经选择
                if(selected[i]) continue;
                // 选择后是否合法
                if(! valid(row, i, cols)) continue;
                // 选择该列
                cols[row] = i;
                selected[i] = true;
                dfs(row + 1, n, cols, selected, ans);
                // restore
                selected[i] = false;
            }
        }
        private boolean valid(int row, int col, int[] cols){
            /*
            遍历左上角元素 和 右上角元素
            左上角斜线位置的规律：行值+列值 == 当前元素的row + col
            右上角： 行值 - 列值 == 当前元素的 row - col
             */
            int sum = row + col;
            int sub = row - col;

            for(int r = 0;r < row; r ++){
                // 遍历当前row之前的所有行 以及对应选择的列
                int c = cols[r];
                if(r + c == sum || r - c == sub) return false;

            }
            return true;
        }

    }

    /*
    valid 思路2:
    既然valid方法是计算之前已选皇后的`(r + c)`是否等于当前待选皇后的`(r +c)`，
    那么我们可以每次选完皇后后，把其`r + c`记录为true，
    后面再选时之需要判断当前皇后的`(r+c)`值是否已经存在过即可，存在过直接跳过。`(r - c)`同理。

    有多少种可能的`r + c`取值呢？同一条右对角线的点的`r + c`值都相同，所以就看有多少条对角线即可，
    对角线数量等于对角元素的个数乘2-1=2n-1。也就是对角元素的`r + c`就代表了它所在的右斜线上所有位置的值。
     */
    class Solution2 {
        public List<List<String>> solveNQueens(int n) {
            List<List<String >> ans = new ArrayList<>();
            // 存每一种结果，也就是每一行选择了哪一列
            int[] cols = new int[n];

            boolean[] selected = new boolean[n];
            // 存储所有 r + c 结果是否已经出现 (r + c) 取值 [0, 2(n-1)] 总共2n-1个
            boolean[] sums = new boolean[2*n - 1];
            // 存储所有 r - c 结果是否已经出现 (r - c) 取值 [-(n - 1), n - 1] 总共2n-1个
            // 然后数组下标范围[0, 2(n - 1)] 对应值 实际范围[-(n-1), n -1] 所以取值时要 + (n - 1)
            boolean[] subs = new boolean[2*n - 1];
            dfs(0, n, cols, selected, ans, sums, subs);

            return ans;
        }


        private void dfs(int row, int n, int[] cols, boolean[] selected, List<List<String >> ans, boolean[] sums, boolean[] subs){
            // 递归退出条件
            if(row == n){
                List<String> res = new ArrayList<>();
                for(int c : cols){
                    // 构建一种n皇后结果
                    char[] chars = new char[n];
                    // 先填充'.'
                    Arrays.fill(chars, '.');
                    chars[c] = 'Q';
                    res.add(new String(chars));
                }
                ans.add(res);
                return;
            }


            // 选择哪一列
            for(int i = 0;i < n;i ++){
                // 是否已经选择 以及 行列值的和与差 已经在之前的皇后中存在过？
                if(selected[i] || sums[row + i] || subs[row - i + n - 1]) continue;

                // 选择该列
                cols[row] = i;
                selected[i] = true;
                sums[row + i] = true;
                subs[row - i + n - 1] = true;
                dfs(row + 1, n, cols, selected, ans, sums, subs);
                // restore
                selected[i] = false;
                sums[row + i] = false;
                subs[row - i + n - 1] = false;
            }
        }


    }



}
