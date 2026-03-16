package com.yike.algorithms.leetcode.order46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 46. 全排列
 * @date: 2025/12/14 08:53
 * @version: 1.0
 */
public class Code46 {

    // 使用bool数组的方式标记已经选的数字
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int len = nums.length;
            List<List<Integer>> ans = new ArrayList<>();

            boolean[] selected = new boolean[len];
            Arrays.fill(selected, false);

            List<Integer> path = Arrays.asList(new Integer[len]);

            dfs(0, len, path, nums, selected, ans);
            return ans;
        }
        private void dfs(int idx, int len, List<Integer> path, int[] nums, boolean[] selected, List<List<Integer>> ans){


            // 退出递归条件
            if(idx == len){
                ans.add(new ArrayList<>(path));
                return;
            }

            // select num
            for(int i = 0;i < len;i ++){
                if(selected[i]) continue;
                path.set(idx, nums[i]);
                // 标记已选
                selected[i] = true;
                // 递归下一个
                dfs(idx + 1, len, path, nums, selected, ans);
                // restore
                selected[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);

        // 读数组长度
        int n = sc.nextInt();
        sc.nextLine();

        // 数组元素
        int[] nums = new int[n];
        for(int i = 0;i < n;i ++){
            nums[i] = sc.nextInt();
        }

        Code46 code46 = new Code46();
        Solution solution = code46.new Solution();

        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }




}

