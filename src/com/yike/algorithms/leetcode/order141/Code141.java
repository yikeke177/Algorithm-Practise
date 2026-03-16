package com.yike.algorithms.leetcode.order141;


/*
给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。
*/

import java.util.List;

/**
 * @author: jyk
 * @description: 141. 环形链表
 * @date: 2025/9/21 16:12
 * @version: 1.0
 */
public class Code141 {

     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }


    public class Solution {
        public boolean hasCycle(ListNode head) {
            /*
             经典题目 方法要背下来 用快慢指针
             快指针每次移动两步
             慢指针每次移动1步
             在环中 他们迟早相遇

             */

            ListNode fast = head;
            ListNode slow = head;
            while(fast != null && fast.next != null){// 一个结点或者空链表都没有环 就直接出循环了
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
    }

}
