package com.yike.algorithms.leetcode.order700;

import com.yike.algorithms.leetcode.data_structures.TreeNode;


/*
给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */

/**
 * @author: jyk
 * @description: 700. 二叉搜索树中的搜索
 * @date: 2025/10/26 20:06
 * @version: 1.0
 */
public class Code700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            /*
            自顶向下递
            遍历检查每个结点是否是要找的子树
            如果为null树 返回null
            如果为val 返回root
            如果不为val 递归左右子树
                1. 小于val 递归左子树
                2. 大于val 递归右子树
             */
            if(root == null) return null;
            if(root.val == val) return root;
            if(root.val > val) return searchBST(root.left, val);
            return searchBST(root.right, val);
        }
    }
}
