package com.yike.algorithms.leetcode.order23;

import java.util.PriorityQueue;

/**
 * @author jyk
 * @description 23. 合并 K 个升序链表
 * @date 2026/3/16 9:50
 */
public class Code23 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
    }

    class Solution{
        public ListNode mergeKLists(ListNode[] lists){
            /*
            使用小顶堆，每次取最小的节点，拼接到现有节点上
            一开始最小的节点肯定是在每个链表头节点中
            之后每次最小的节点可能是剩下的头节点中 + 当前最小节点的下一个（新头节点）
             */

            // 1. 初始化小顶堆 添加当前所有头节点
            // 2. 开始从堆中逐个取最小节点 拼接到当前节点上。
            // 3. 每次取一个最小节点 还要将其next节点添加到优先队列中
            PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

            // 添加当前所有头节点
            for(int i = 0;i < lists.length;i ++){
                // 注意可能有空链表
                if(lists[i] != null){
                    pq.add(lists[i]);
                }
            }

            ListNode dummy = new ListNode();
            ListNode cur = dummy;

            // 每次取队列尾部元素
            while(!pq.isEmpty()){
                ListNode node = pq.poll();
                cur.next = node;
                cur = cur.next;

                if(node.next != null){
                    pq.add(node.next);
                }


            }

            return dummy.next;


        }


    }
}
