package com.yike.algorithms.leetcode.order82;


import java.util.List;

/**
 * @author: jyk
 * @description: 82. 删除排序链表中的重复元素 II
 * @date: 2026/1/15 10:03
 * @version: 1.0
 */
public class Code82 {
    public static class ListNode {
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


    public static class Solution{

        public ListNode deleteDuplicates(ListNode head){

            ListNode dummy = new ListNode(-1, head);
            ListNode cur = dummy;
            while(cur.next != null && cur.next.next != null){
                // 如果有重复
                if(cur.next.val == cur.next.next.val){
                    // 记录重复元素
                    int val = cur.next.val;
                    // 开始删除
                    while(cur.next != null && cur.next.val == val){

                        cur.next = cur.next.next;

                    }
                    continue;
                }
                // 如果没重复
                cur = cur.next;


            }
            return dummy.next;


        }

    }
}
