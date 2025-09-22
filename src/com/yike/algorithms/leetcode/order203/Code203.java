package com.yike.algorithms.leetcode.order203;

/*
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */


import java.util.List;

/**
 * @author: jyk
 * @description: 203. 移除链表元素
 * @date: 2025/9/21 18:12
 * @version: 1.0
 */
public class Code203 {



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 方法一：双指针
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            /*
            遍历链表并删除结点 移除结点需要两个指针配合
            cur指针指向访问当前元素
            pre指向前一个元素
            每次两个指针向前移动一步
            当访问到val值符合的结点时执行删除操作
            删除操作 pre.next = cur.next
            更新指针 cur = cur.next pre不动 然后进入下一个循环

            需要一个虚拟结点 因为第一个结点也可能需要删除
            如果删除到变成空链表 则返回的是哨兵结点的next
            什么时候需要用到哨兵结点？
            虚拟结点的好处？可以统一返回形式 统一代码 比如为空链表的时候
             */
            // 虚拟结点
            ListNode dummy = new ListNode(0, head);

            // 双指针初始化
            ListNode pre = dummy;
            ListNode cur = head;

            while(cur != null){
                if(cur.val == val) {
                    pre.next = cur.next;

                    cur = cur.next;
                }else{
                    pre = pre.next;
                    cur = cur.next;
                }
            }

            return dummy.next;


        }
    }
    // 方法二：单指针
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            /*
            使用单指针 那么cur就指向的是待删除元素的前一个元素
            初始化时指向的是head的前一个元素 也就是虚拟结点

            删除操作：
            cur.next = cur.next.next;
            更新指针（如果没删除，删除了则不更新指针）：
            cur = cur.next;
             */
            // 虚拟结点
            ListNode dummy = new ListNode(0, head);

            // 双指针初始化
            ListNode cur = dummy;

            while(cur.next!= null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }else{
                    cur = cur.next;
                }
            }

            return dummy.next;


        }
    }
}
