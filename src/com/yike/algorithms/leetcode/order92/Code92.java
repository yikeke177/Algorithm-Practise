package com.yike.algorithms.leetcode.order92;

/*
给你单链表的头指针 head 和两个整数 left 和 right ，
其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */


/**
 * @author: jyk
 * @description: 92. 反转链表 II
 * @date: 2025/9/22 10:49
 * @version: 1.0
 */
public class Code92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            /*
            一定要在纸上画图模拟
            宏观的思路是先反转链表段，然后再处理剩下的方向。
            反转链表需要用到三个指针
            处理剩下的方向需要一个辅助指针指向链表段的前一个结点
            需要使用虚拟结点，避免特判
             */
            ListNode dummy = new ListNode(-1,head);
            ListNode p = dummy;
            for(int i = 0;i < left-1;i++){
                // 走left-1步到待反转链表段的前一个结点
                p = p.next;
            }

            // 初始化cur pre next指针
            ListNode pre = p.next;
            ListNode cur = pre.next;
            ListNode next = cur;

            // 反转链表段
            for(int i = 0;i < (right - left);i ++){
                // 循环执行反转方向(right - left)次
                next = cur.next; // 先初始化好next

                // 执行反转操作
                cur.next = pre;
                //指针移动到下一组结点
                pre = cur;
                cur = next;
            }

            // 处理剩下的方向 链表段两端结点的方向
            p.next.next = cur;
            p.next = pre;

            // 返回头结点
            return dummy.next;

        }
    }

}
