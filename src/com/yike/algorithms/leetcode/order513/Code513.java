package com.yike.algorithms.leetcode.order513;

import com.yike.algorithms.leetcode.data_structures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: jyk
 * @description: 513. 找树左下角的值
 * @date: 2025/10/12 15:16
 * @version: 1.0
 */
public class Code513 {

    class Solution {
        public int findBottomLeftValue(TreeNode root) {
        /*
        层序遍历时先加入右结点 再加入左结点
        这样队列里最后一个元素就是答案了
        */

            Deque<TreeNode> que = new ArrayDeque<>();

            que.addFirst(root);
            TreeNode node = null;
            while(!que.isEmpty()){
                node = que.removeLast();
                if(node.right != null) que.addFirst(node.right);
                if(node.left != null) que.addFirst(node.left);
            }
            return node.val;
        }
    }
}
