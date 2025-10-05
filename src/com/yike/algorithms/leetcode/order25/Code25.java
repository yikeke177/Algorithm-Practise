package com.yike.algorithms.leetcode.order25;

/*
25. K 个一组翻转链表
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */


import java.util.Scanner;

/**
 * @author: jyk
 * @description: 25. K 个一组翻转链表
 * @date: 2025/9/23 16:11
 * @version: 1.0
 */
public class Code25 {



    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            /*
            每k个结点反转(包括k-1次反转) 然后跳过一次反转
            反转k个结点的操作和题目 92.反转链表II 中反转一段链表一样 需要一个指针p指向“段”的前一个结点来配合
            如此循环 循环次数的估计需要直到总的结点个数
            所以需要先统计结点的个数
             */
            // 统计结点个数
            int cnt = 0;
            ListNode p = head;
            while(p != null){
                cnt ++;
                p = p.next;
            }
            // 虚拟结点
            ListNode dummy = new ListNode(-1,head);
            // 初始化四个指针
            p = dummy;
            ListNode pre = p;
            ListNode cur = pre.next;
            ListNode next = cur;

            ListNode tmp = dummy;

            for(int i = 0;i < (cnt / k);i ++){// 外层循环 需要反转的“链表段”数
                // p也移动到下一段 注意这里容易出错
//                p = pre;不是移动到pre 而是要先用指针暂存一下最开始的p.next 因为段反转后该结点边段的尾结点
                p = tmp;

                // 指针移动到下一段
                pre = cur;
                cur = cur.next;
                next = cur;

                for(int j = 0;j < (k - 1);j ++){ // 反转链表段时的反转次数
                    next = cur.next;
                    // 反转操作
                    cur.next = pre;
                    // 更新指针
                    pre = cur;
                    cur = next;
                }
                // 处理“链表段”两端的方向
                tmp = p.next; // 暂存一下最开始的p.next 因为反转后该结点变成段的尾结点 后面要用到
                p.next.next = cur;
                p.next = pre;

                /*
                注意 我一开始把这段代码放在后面 结果出错了 比如对于链表1 2会在cur=cur.next报错
                原因是我在初始化四个指针的时候不是初始化在dummy结点上 而是直接初始化在第一个反转对上了

                p = tmp;

                // 指针移动到下一段
                pre = cur;
                cur = cur.next;
                next = cur;
                */

            }
            return dummy.next;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Code25 code25 = new Code25();

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
5
1 2 3 4 5
 */
        Solution solution = code25.new Solution();
        ListNode newHead = solution.reverseKGroup(head, 2);

        // 打印链表
        p = newHead;
        System.out.println("反转后：");
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }
}
