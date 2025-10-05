package com.yike.algorithms.leetcode.order110;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 110. 平衡二叉树
 * @date: 2025/10/4 10:53
 * @version: 1.0
 */
public class Code110 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            /*
            递归求左右子树的最大高度 = max(左子树最大高度, 右子树最大高度) + 1
            如果左右子树任意一个高度为-1 就返回-1
            然后如果左子树和右子树高度差>1 就返回-1
             */
            // 如果在求root的高度中 不是-1 就说明左右子树高度差合格
            return maxHeight(root) != -1;

        }
        private int maxHeight(TreeNode root){
            // 空树
            if(root == null)return 0;

            // 如果非空树
            int leftHeight = maxHeight(root.left);
            int rightHeight = maxHeight(root.right);
            // 先判断是否为-1 (我第一次写的时候，漏掉了这句判断)
            if(leftHeight == -1 || rightHeight == -1) return -1;
            if(Math.abs(leftHeight - rightHeight) > 1) return -1;
            // 否则 返回正常的树高
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
