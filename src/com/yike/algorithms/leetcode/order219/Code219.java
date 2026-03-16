package com.yike.algorithms.leetcode.order219;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */


import java.util.*;

/**
 * @author: jyk
 * @description: 219. 存在重复元素 II
 * @date: 2025/9/19 15:08
 * @version: 1.0
 */
public class Code219 {
    // 方法一1： 滑动窗口 复杂度O(n) 更好的写法 推荐
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /**
             * 维护一个长度不超过k的窗口
             * 窗口左端点指针为l 右端点指针为r 以右端点为基准 for循环右端点往右一步步移动
             * 当窗口长度>k了再移动左端点指针l 以确保窗口长度始终<=k
             * 这种写法相比于下面的方法一2的写法 指针移动的边界判断更清晰 只需要保证r < len即可 且能保证窗口大小始终是k
             * 但是缺点是如果想判断窗口内的元素有重复 则需要一个个比较 所以改为将窗口用一个set来维护 保证set长度始终为k即可
             */
            int len = nums.length;
            Set<Integer> set = new HashSet<>();

            for(int i = 0;i < len;i ++){
                // 必须先检查是否存在重复 再添加元素 因为如果先添加 那么set集合是不能添加重复元素的
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
                if(set.size() >= k+1){ // 注意维护的窗口大小是k+1 不是k 确保窗口内元素始终<=k+1
                    set.remove(nums[i - k]); // 移除窗口首元素
                }
            }

            return false;
        }
    }
    // 方法一2： 滑动窗口 自己最初的写法 但不推荐 复杂度O(n*k)
    class Solution2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /**
             * 维护一个长度不超过k的窗口
             * 指针l遍历数组 指针r边移动边检查元素是否等于nums[l] 直到长度超出k或者存在相等元素
             */
            int len = nums.length;

            for(int i = 0;i <= len - 2;i ++){
                int j = i + 1;
                while(j < len && j - i <= k){
                    if(nums[j] == nums[i]) return true;
                    j ++;
                }
            }
            return false;
        }
    }
    // 方法二： 哈希表 复杂度O(n)
    class Solution3 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            /*
             维护一个长度不超过k的窗口
             指针l遍历数组 指针r边移动边检查元素是否等于nums[l] 直到长度超出k或者存在相等元素
             */
            int len = nums.length;

            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i < len;i ++){
                if(map.containsKey(nums[i])){
                    if(i - map.get(nums[i]) <= k)return true;
                }
                map.put(nums[i], i);
            }
            return false;

        }
    }


    public static void main(String[] args){
        Code219 code219 = new Code219();
        Solution solution = code219.new Solution();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // 吞掉回撤符
        int[] nums = new int[n];
        for(int i = 0;i < n;i ++){
            nums[i] = sc.nextInt();
        }
        System.out.println(solution.containsNearbyDuplicate(nums, k));



    }
}
