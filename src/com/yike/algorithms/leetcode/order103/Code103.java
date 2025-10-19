package com.yike.algorithms.leetcode.order103;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

import java.util.*;

/**
 * @author: jyk
 * @description: 103. 二叉树的锯齿形层序遍历
 * @date: 2025/10/12 14:47
 * @version: 1.0
 */
public class Code103 {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
        只需要在偶数层的时候将数组翻转一下就行了
        */
            if(root == null) return new ArrayList<List<Integer>>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            // 队列
            Deque<TreeNode> que = new ArrayDeque<TreeNode>();
            que.addFirst(root);

            // 记录奇偶层
            boolean even = false;

            while(!que.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                int len = que.size();
                for(int i = 0;i < len;i ++){
                    TreeNode tmp = que.removeLast();
                    list.add(tmp.val);
                    if(tmp.left != null) que.addFirst(tmp.left);
                    if(tmp.right != null) que.addFirst(tmp.right);
                }

                if(even) Collections.reverse(list);
                ans.add(list);
                even = !even;
            }

            return ans;

        }
    }
}
