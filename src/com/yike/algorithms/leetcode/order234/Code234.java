package com.yike.algorithms.leetcode.order234;

/*
234. 回文链表
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */





/**
 * @author: jyk
 * @description: 234. 回文链表
 * @date: 2025/9/24 10:23
 * @version: 1.0
 */
public class Code234 {

    public class ListNode {
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
        public boolean isPalindrome(ListNode head) {
            /*
            思路一：
            回文链表就是正反读都一样
            那么可以先反转链表 然后逐个对比
            但是这个思路需要一个额外的链表
            思路二：
            判断回文字符串的方法是第一个字符和最后一个字符比较，然后第二个字符和倒数第二个字符比较，依此类推
            那么这题也可以类似思路
            但需要首先找到中间结点 然后反转后半段 再同时从前后两个链表进行比较
            找到中间结点：快慢指针
             */

            // 1. 找中间结点
            ListNode fast = head, slow = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            // 2. 反转后半段
            ListNode pre = null;
            ListNode cur = slow;
            ListNode next = cur;
            while(cur != null){
                next = cur.next;
                // 反转
                cur.next = pre;
                // 更新指针
                pre = cur;
                cur = next;
            }
            // 3. 比较前后两段链表
            ListNode head2 = pre;
            ListNode p1 = head;
            ListNode p2 = head2;
            while(p2 != null){
                if(p1.val != p2.val)return false;
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;


        }
    }
}
