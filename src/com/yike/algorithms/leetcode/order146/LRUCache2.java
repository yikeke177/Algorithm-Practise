package com.yike.algorithms.leetcode.order146;

import java.util.HashMap;

class LRUCache2{

    static class Node{
        private int key, val;
        private Node pre, next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node dummy;

    LRUCache2(int capacity){
        this.capacity = capacity;
        dummy = new Node(-1, -1);
        dummy.pre = dummy;
        dummy.next = dummy;
        map = new HashMap<Integer, Node>();
    }


    int get(int key){
		/*
		如果不存在，直接返回-1
		如果存在
		删除节点 从头插入节点
		返回
		*/

        Node node = map.get(key);
        if(node == null) return -1;

        removeNode(node);
        addHead(node);

        return node.val;


    }


    void put(int key, int val){
		/*
		如果存在
		更新val 删除节点 从头插入

		如果不存在
		new新节点 从头插入
		如果map长度超出capacity 删除尾节点
		*/

        Node node = map.get(key);
        if(node != null){
            node.val = val;
            removeNode(node);
            addHead(node);
            return;
        }

        Node newNode = new Node(key, val);
        addHead(newNode);
        map.put(key, newNode);

        if(map.size() > capacity){
            map.remove(dummy.pre.key);
            removeNode(dummy.pre);
        }


    }

    void addHead(Node node){
        node.next = dummy.next;
        node.pre = dummy;
        dummy.next.pre = node;
        dummy.next = node;

    }
    void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }


    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


    }



}


