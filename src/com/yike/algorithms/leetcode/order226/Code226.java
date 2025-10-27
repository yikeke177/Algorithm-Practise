package com.yike.algorithms.leetcode.order226;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 226. 翻转二叉树
 * @date: 2025/10/26 19:49
 * @version: 1.0
 */
public class Code226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            /*
            递归翻转每个结点对应的树 = 先翻转左子树和右子树 然后交换左右子树

             */
            // 空结点 直接返回
            if(root == null) return null;

            // 一般树 交换左右子树 先翻转左右子树 再交换左右结点
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.left = right;
            root.right = left;
            return root;
        }

    }
}
