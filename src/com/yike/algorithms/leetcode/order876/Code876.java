package com.yike.algorithms.leetcode.order876;
/**
 * 876. 链表的中间结点
 *
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */


import java.util.List;

/**
 * @author: jyk
 * @description: 876. 链表的中间结点
 * @date: 2025/9/21 15:38
 * @version: 1.0
 */
public class Code876 {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            /*
            找到单链表的中间结点
            难点在于方向是单向的只能往前走不能往回走
            所以指针向前走的过程中是扩大自己已知范围的过程 它只能直到自己已经走过的地方的中间结点
            那么就得使得当指针走到最后时 正好也就知道中间结点是哪个了
            慢指针每次移动1步 快指针每次移动两步 相当于两个指针同时出发 但快指针的移动速度是慢指针的2倍
            对于奇数个结点 有偶数个间隔 正好能整除2
            对于偶数个结点 有奇数个间隔 移动到最后是空结点
            所以循环的终止条件是快指针的下一个为null结点或者本身为null结点
             */
            // 题目中结点至少一个 所以不用判断空链表
            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;


        }
    }
}
