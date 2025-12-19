package com.yike.algorithms.leetcode.order198;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: jyk
 * @description: 198. 打家劫舍
 * @date: 2025/12/16 19:11
 * @version: 1.0
 */
public class Code198 {
    /**
     * 回溯写法
     * 空间复杂度太高过不了
     */
    class Solution1 {
        public int rob(int[] nums) {
            /*
            回溯 从后往前（从前往后也可以）
            选了第i个 则一定没有选第i-1个 就只能从第i-2个物品转移过来
            没选第i个 则表示可以从第i-1个物品转移过来
            所以递推公式：dfs(i)表示从前i个元素里选，最大的偷盗金额是多少
            1. 选第i个 那么前i个元素里选的最大金额 = 从前i - 2个里选的最大金额dfs(i-2) + 当前金额
            2. 不选第i个 那么前i个元素里选的最大金额 = 从前i - 1个元素里选的最大金额
            dfs(i) = max(dfs(i - 2) + nums[i], dfs(i - 1))
             */

            int n = nums.length;
            return dfs(n-1, nums);



        }


        private int dfs(int i, int[] nums){
            // 递归退出条件 当i < 0时
            if(i < 0) return 0;

            return Math.max(dfs(i - 1, nums), dfs(i - 2, nums) + nums[i]);
        }
    }

    /**
     * 记忆化搜索 保存重复记忆的值到哈希表中 避免重复计算带来的时间开销
     * 空间复杂度优化到O(n)
     */
    class Solution2 {
        public int rob(int[] nums) {
            /*
            dfs(i) = max(dfs(i - 2) + nums[i], dfs(i - 1))
            使用数组存储每次递归返回值
            如果已经计算过就不必重复计算了
             */
            int n = nums.length;
            int[] cache = new int[n];
            Arrays.fill(cache, -1);


            return dfs(n-1, nums, cache);



        }


        private int dfs(int i, int[] nums, int[] cache){
            // 递归退出条件 当i < 0时
            if(i < 0) return 0;
            if(cache[i] != -1)return cache[i];
            int res = Math.max(dfs(i - 1, nums, cache), dfs(i - 2, nums, cache) + nums[i]);
            cache[i] = res;
            return res;
        }
    }

    /**
     * 递推 动态规划
     * 把递归用循环 + 数组的方式优化
     *
     */
    class Solution3 {
        public int rob(int[] nums) {
            int n = nums.length;

            int[] f = new int[n + 1];
            f[0] = 0;
            f[1] = nums[0];
            for(int i = 2;i <= n; i ++){
                f[i] = Math.max(f[i - 1], f[i - 2] + nums[i-1]);
            }

            return f[n];
        }
    }

    class Solution4 {
        public int rob(int[] nums) {
            int n = nums.length;

            int[] f = new int[n + 2];
            for(int i = 0;i < n; i ++){
                f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
            }

            return f[n + 1];
        }
    }

    /**
     * 滚动数组优化空间复杂度
     * 直接把数组去掉了
     */
    class Solution5 {
        public int rob(int[] nums) {
            /*
            f(-1) = 0
            f(0) = nums[0]

            f(1) = f(0), f(-1) + nums[1]
            f(2) = f(1), f(0) + nums[2]
            f(3) = f(2), f(1) + nums[3]
            也就是f(i) 只和它的上一个 和 上上个 这两个状态有关
            所以之需要用两个变量分别保存上个 和 上上个状态
            每次更新上个 和上上个状态即可
            f0表示上上个 f1表示上上个
            则 new_f = max(f1, f0 + nums[i])
            然后更新两个状态：
            上上个状态：f0 = f1
            上个状态： f1 = new_f

            f(i) = f(i - 1), f(i - 2) + nums[i]

             */
            int n = nums.length;
            int f0 = 0;
            int f1 = nums[0];
            for(int i = 1;i < n;i ++){
                int newF = Math.max(f1, f0 + nums[i]);
                // 更新f0 f1
                f0 = f1;
                f1 = newF;
            }
            return f1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = new int[n];
        for(int i = 0;i < n;i ++){
            nums[i] = scanner.nextInt();
        }

        Code198 code198 = new Code198();
        Solution1 solution = code198.new Solution1();
        Solution2 solution2 = code198.new Solution2();
        Solution3 solution3 = code198.new Solution3();
        Solution4 solution4 = code198.new Solution4();
        Solution5 solution5 = code198.new Solution5();

        System.out.println(solution5.rob(nums));

        /*
        4
        1 2 3 1
         */
    }

}
