package com.yike.algorithms.leetcode.order2130;

/*
2130. 链表最大孪生和

 */


/**
 * @author: jyk
 * @description: 2130. 链表最大孪生和
 * @date: 2025/9/24 16:37
 * @version: 1.0
 */
public class Code2130 {
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

        public int pairSum(ListNode head) {
            /*
            类似于题目143. 重排链表
            都是找前后成对结点
            先分成前后两段
            后段反转
            遍历前后两个链表计算孪生和
             */
            // 找中间结点
            ListNode mid = findMidNode(head);
            // 反转后半段链表
            ListNode head2 = reverseList(mid);

            // 遍历两个链表 计算孪生和
            int ans = Integer.MIN_VALUE;
            while(head2 != null){ // 题目说链表结点是偶数个 不用考虑奇数情况
                ans = Math.max(ans, head.val + head2.val);
                head = head.next;
                head2 = head2.next;
            }
            return ans;

        }
        private ListNode reverseList(ListNode head) {
            // 三指针法
            ListNode pre = null;
            ListNode cur = head;
            ListNode next = cur;
            while(cur != null){
                next = cur.next;

                cur.next = pre;

                pre = cur;
                cur = next;
            }
            return pre;
        }

        private ListNode findMidNode(ListNode head) {
            // 快慢指针法
            ListNode fast = head, slow = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

}
