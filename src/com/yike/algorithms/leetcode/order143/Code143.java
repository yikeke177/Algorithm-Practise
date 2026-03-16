package com.yike.algorithms.leetcode.order143;

/*
143. 重排链表
 */
import com.yike.algorithms.leetcode.order143.ListNode;

import java.util.Scanner;

/**
 * @author: jyk
 * @description: 143. 重排链表
 * @date: 2025/9/24 15:56
 * @version: 1.0
 */
public class Code143 {

    class Solution {
        public ListNode reorderList(ListNode head) {
            /*
            先理解题意 其实就是将链表分成前后两段
            后半段反转
            然后前后两段链表结点交错分布即可
            所以分成三步
            1. 找到中间结点
            2. 反转后段链表
            3. 前后两段链表交错合并
             */
            // 找到中间结点
            ListNode mid = findMidNode(head);

            // 反转后半段链表
            ListNode head2 = reverseList(mid);

            // 链表交错合并
            ListNode p1 = head, p2 = head2;
            ListNode tmp1 = p1, tmp2 = p2;
            /*
            这个循环终止条件有点巧妙 尤其是对于偶数个结点来说
            最后p1和p2分布指向中间两个结点时就结束循环了，不需要再执行相互指向的操作 因为此时链表本来就是p1->p2的状态
             */
            while(p2.next != null){
                // 临时存储p1和p2下一个结点
                tmp1 = p1.next;
                tmp2 = p2.next;

                // 合并
                p1.next = p2;
                p2.next = tmp1;

                // 更新指针
                p1 = tmp1;
                p2 = tmp2;
            }
            return head;// 方便调试debug 实际上题目是返回void

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Code143 code25 = new Code143();

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 构造链表
        for(int i = 0;i < n;i ++){
            ListNode newNode = new ListNode(sc.nextInt(), null);
            p.next = newNode;
            p = p.next;
        }
        // 打印链表
        System.out.println("反转前：");
        ListNode head = dummy.next;
        p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

        //
/*

4
1 2 3 4
 */        Solution solution = code25.new Solution();
        ListNode newHead = solution.reorderList(head);

        // 打印链表
        p = newHead;
        System.out.println("反转后：");
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
