package com.yike.algorithms.leetcode.order21;

import com.yike.algorithms.leetcode.order2130.Code2130;

/**
 * @author: jyk
 * @description: 21. 合并两个有序链表
 * @date: 2025/9/24 17:05
 * @version: 1.0
 */
public class Code21 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            /*
            遍历两个链表
            难点在于不想数组合并那样可以用一个额外的数组
            这里如何在原链表上操作是难点

            链表比较 然后要保存已经合并好的上一个结点
            如果一个链表已经结束，另一个链表还剩有几个结点该如何处理？
             */
            ListNode p1 = list1, p2 = list2;
            // 需要一个虚拟结点 作为已经合并好的链表
            ListNode dummuy = new ListNode(-1);
            // 指针永远指向已经合并好的链表的最后一个结点
            ListNode p = dummuy;

            while(p1 != null && p2 != null){
                if(p1.val < p2.val){
                    p.next = p1;
                    p1 = p1.next;
                }else{
                    p.next = p2;
                    p2 = p2.next;
                }
                p = p.next;
            }

            // 如果还有剩下的结点则处理 直接拼接到后面
            if(p1 != null){
                p.next = p1;
            }else if(p2 != null){
                p.next = p2;
            }
            return dummuy.next;

        }
    }
}
