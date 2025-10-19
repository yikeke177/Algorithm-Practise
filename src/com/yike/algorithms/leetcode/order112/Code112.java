package com.yike.algorithms.leetcode.order112;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 112. 路径总和
 * @date: 2025/10/12 15:38
 * @version: 1.0
 */
public class Code112 {

    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            /*
            先思考这个递归函数的功能：从当前结点root到叶子结点是否存在sum = targetSum
            递归子树时sum = sum - val
             */
            if(root == null) return false;
            // 如果是叶子结点
            if(root.left == null && root.right == null){
                if(root.val == targetSum)return true;
            }

            // 非叶子结点 递归左右子树
            // 左子树没找到 则继续递归右子树
            if(hasPathSum(root.left, targetSum - root.val)) return true;
            return hasPathSum(root.right, targetSum - root.val);
        }

    }
}
