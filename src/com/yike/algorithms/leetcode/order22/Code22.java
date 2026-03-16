package com.yike.algorithms.leetcode.order22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 22. 括号生成
 * @date: 2025/12/12 18:49
 * @version: 1.0
 */
public class Code22 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] path = new char[2*n];

            dfs(0, 0, 0, path, n, ans);
            return ans;
        }

        private void dfs(int idx, int leftCnt, int rightCnt, char[] path, int n, List<String> ans){
            if(idx == 2*n){
                ans.add(new String(path));
                return;
            }

            // 选左括号 当左括号数量 < n时可以选
            if(leftCnt < n){
                path[idx] = '(';
                dfs(idx + 1, leftCnt + 1, rightCnt, path, n, ans);
                // 不需要恢复现场 因为这里path是数组不是队列 后面会直接覆盖之前的值
            }
            // 选右边括号 当 右括号数量 < 左括号数量时 可选
            if(rightCnt < leftCnt){
                path[idx] = ')';
                dfs(idx + 1, leftCnt, rightCnt + 1, path, n, ans);
                // 不需要恢复现场
            }
            return;

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 括号对数量
        int n = sc.nextInt();

        Code22 code22 = new Code22();
        Solution solution = code22.new Solution();

        List<String> res = solution.generateParenthesis(n);
        System.out.println(res);

    }

}
