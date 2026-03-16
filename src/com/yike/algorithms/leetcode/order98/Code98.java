package com.yike.algorithms.leetcode.order98;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */



/**
 * @author: jyk
 * @description: 98. 验证二叉搜索树
 * @date: 2025/10/5 09:10
 * @version: 1.0
 */
public class Code98 {
    /*
    根据灵神的题解，有三种思路。
    【验证二叉搜索树【基础算法精讲 11】】 https://www.bilibili.com/video/BV14G411P7C1/?share_source=copy_web&vd_source=706e89d02d8f2e3054b318652ffa1de4
     前序遍历 中序遍历 后序遍历
     */

    /*思路一：前序遍历
    一定要画一棵二叉搜索树来分析
    对于某个结点
    它的左子树的根节点必须满足 在满足当前结点取值范围的基础上 && 值<当前结点的值 （两个范围取并集）
    它的右子树的根节点必须满足 在满足当前结点取值范围的基础上 && 值>当前结点的值

    初始根节点的取值范围[-inf, +inf]
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        /**
         * 自顶向下“递”
         * @param root 当前访问结点
         * @param left_bound 当前结点的取值范围左边界
         * @param right_bound 当前结点的取值范围右边界
         * @return 是否为BST
         */
        private boolean checkBST(TreeNode root, long left_bound, long right_bound){
            // 正常终止条件：如果为null
            if(root == null) return true;

            // 异常终止条件：非BST
            if(root.val <= left_bound || root.val >= right_bound) return false;

            // 否则继续往下递归
            // 左子树更新取值范围的右边界
            // 右子树更新取值范围的左边界
            return checkBST(root.left, left_bound, root.val) && checkBST(root.right, root.val, right_bound);
        }
    }

    /*思路二：中序遍历
    如果满足中序遍历的结果是升序 也是二叉搜索树
    即只需要在访问当前结点时
    判断起左子树的最后一个访问结点 是否 < 当前结点值

    先判断左子树是否为二叉树 如果是则继续判断父结点 父结点符合要求 则继续判断右子树

     */

    class Solution2 {
        private int pre = Integer.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            return checkBST(root);
        }

        private boolean checkBST(TreeNode root) {
            // 正常终止条件
            if (root == null) return true;

            // 先访问左子树是否是二叉搜索树
            if (!checkBST(root.left)) return false;
            //TODO: 为什么不能这样写？
            // 因为如果左子树是二叉搜索树，则得进一步验证父结点和右子树
            // 而我如果直接返回true 后面的代码就不会继续被执行了
//            if(checkBST(root.left)) return true;
            // 访问父结点是否大于左子树最大值
            if (root.val <= pre) return false;
            // 否则 更新pre并继续访问右子树
            pre = root.val;
            // 访问右子树
            return checkBST(root.right);
        }
    }

}
