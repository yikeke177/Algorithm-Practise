package com.yike.algorithms.leetcode.data_structures;

/**
 * @author: jyk
 * @description: 数据结构“树结点”类
 * @date: 2025/9/27 13:50
 * @version: 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}