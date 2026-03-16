package com.yike.algorithms.leetcode.order142;

/*
142. 环形链表 II

 */


/**
 * @author: jyk
 * @description: 142. 环形链表 II
 * @date: 2025/9/24 15:05
 * @version: 1.0
 */
public class Code142 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            /*
            具体思路的推导见我的笔记或者参考灵神的视频：
            【环形链表II【基础算法精讲 07】】 https://www.bilibili.com/video/BV1KG4y1G7cu/?share_source=copy_web&vd_source=706e89d02d8f2e3054b318652ffa1de4
            思路就是快慢指针先找到相遇点。
            然后slow从相遇点开始走，另一个指针从head开始走，当他两相遇即为入口结点
             */
            ListNode fast = head, slow = head, p = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){// 找到相遇点
                    while(p != slow){
                        slow = slow.next;
                        p = p.next;
                    }
                    return p;
                }
            }
            return null;
        }
    }
}
