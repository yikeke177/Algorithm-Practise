package com.yike.algorithms.leetcode.order206;


/**
 * @author: jyk
 * @description: 206. 反转链表
 * @date: 2025/9/21 16:33
 * @version: 1.0
 */
public class Code206 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            /*
            反转的方法 相邻两结点 两两之间指针方向交换即可
            难点在于交换操作中指针的操作顺序上
            需要三个指针配合 pre cur next 交换的主要是pre 和 cur 的方向 next用于方便指针的移动更新到下一组
            第一次写卡住我的点在于最后终止状态时 pre指向最后一个结点 cur指向 null next就无法指向cur的next了
            原因在于我总是想着三个指针一次性都更新状态 实际上可以把next的更新放在下一个循环开始 这样终止条件就是cur!=null了
            这是因为三指针的缺点 导致很难使得一开始状态就是三个指针分别指向三个不同的位置 因为在末尾情况 第二个指针cur指向null后
            next就没地方可指了 所以三指针的初始化其实是指向两个结点 pre指向前一个结点 cur和next指向同一个结点 然后循环里检查cur是否为null
            只有当cur不为null的时候 next才能更新到第三个不同的结点上

            一定要画图模拟方向的交换 以及三个指针的移动
            */
            // 初始情况 pre指向null cur指向head next指向head（循环里第一个操作是next的更新）
            ListNode pre = null, cur = head, next = head;

            while(cur != null){
                next = cur.next;
                // 交换方向
                cur.next = pre;
                // 更新指针pre 和cur
                pre = cur;
                cur = next;

            }
            // 终止状态时是pre指向最后一个结点 它成为了新的头结点
            return pre;

        }
    }
}
