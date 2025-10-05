package com.yike.algorithms.leetcode.order102;

/*
102. 二叉树的层序遍历


 */


import com.yike.algorithms.leetcode.data_structures.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: jyk
 * @description: 102. 二叉树的层序遍历
 * @date: 2025/9/28 15:54
 * @version: 1.0
 */
public class Code102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            /*
            层序遍历 使用队列
             */

            Queue<TreeNode> que = new LinkedList<>();

            List<List<Integer>> ans = new ArrayList<>();

            if(root != null) que.add(root);

            while(! que.isEmpty()){
                int len = que.size();
                List<Integer> list = new ArrayList<>();

                for(int i = 0;i < len;i ++){
                    // 去除队首元素并移除
                    TreeNode node = que.remove();

                    list.add(node.val);

                    // 添加子结点
                    if(node.left != null) que.add(node.left);
                    if(node.right != null) que.add(node.right);

                }
                // 一层遍历完 把当前层答案添加
                ans.add(list);
            }
            return ans;
        }

    }

}
