package com.yike.algorithms.leetcode.order108;

import com.yike.algorithms.leetcode.data_structures.TreeNode;



/**
 * @author: jyk
 * @description: 108. 将有序数组转换为二叉搜索树
 * @date: 2025/10/27 10:34
 * @version: 1.0
 */
public class Code108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            /*
            数组每次二分 中间的数字作为根节点 左边的数全部小于它 右边的数全部大于它
            那么就可以递归左右两边的数组了
            返回值就是数组的根节点
            区间划分可以是左闭右开 也可以是左闭右闭 区别是最后的边界条件
             */
            return dfs(nums, 0, nums.length);
        }
        private TreeNode dfs(int[] nums, int left, int right){
            if(left >= right) return null;
            int mid = (right + left) >> 1;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid);
            root.right = dfs(nums,mid + 1,right);
            return root;
        }
    }

    // 闭区间
    class Solution2 {
        public TreeNode sortedArrayToBST(int[] nums) {
            /*
            数组每次二分 中间的数字作为根节点 左边的数全部小于它 右边的数全部大于它
            那么就可以递归左右两边的数组了
            返回值就是数组的根节点
             */
            return dfs(nums, 0, nums.length - 1);
        }
        private TreeNode dfs(int[] nums, int left, int right){
            if(left > right) return null;
            int mid = (right + left) >> 1;

            TreeNode root = new TreeNode(nums[mid]);
            root.left = dfs(nums, left, mid-1);
            root.right = dfs(nums,mid + 1,right);
            return root;
        }
    }
}
