package com.yike.algorithms.leetcode.order100;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/**
 * @author: jyk
 * @description: 100. 相同的树
 * @date: 2025/9/28 16:10
 * @version: 1.0
 */
public class Code100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            /*
            还是递归的思想
            两棵树相同 = 左右子树相同 且 根结点相同
             */

            // 终止条件：两棵子树都为空
            if(p == null && q == null) return true;

            // 根节点不相同 直接返回false
            if((p == null && q != null) || (p != null && q == null)) return false;
            if(p.val != q.val) return false;
            // 如果根节点相同 继续递归检查子树是否相同
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
