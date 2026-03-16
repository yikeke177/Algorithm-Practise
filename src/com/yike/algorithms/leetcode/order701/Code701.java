package com.yike.algorithms.leetcode.order701;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 701. 二叉搜索树中的插入操作
 * @date: 2025/10/26 20:19
 * @version: 1.0
 */
public class Code701 {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            /*
            递归 含义是 返回插入该结点完成后的子树root
            如果为null 则直接插入 返回本身结点
            如果大于val 则插到左子树里面 并更新root的左子树
            如果小于val 则插到右子树里面 并更新root的右子树
            左或右子树都插完后 返回插完后的当前结点
             */
            if(root == null){
                return new TreeNode(val);
            }
            if(root.val > val) root.left = insertIntoBST(root.left, val);
            else root.right = insertIntoBST(root.right, val);

            return root;
        }
    }
}
