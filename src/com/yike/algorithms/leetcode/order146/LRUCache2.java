package com.yike.algorithms.leetcode.order146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jyk
 * @description: TODO
 * @date: 2025/12/31 09:40
 * @version: 1.0
 */
class LRUCache2{
    static class Node{
        int key, value;

        Node prev, next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node dummy = new Node(-1, -1);

    // 构造函数
    LRUCache2(int capacity){

        this.capacity = capacity;
        this.dummy.prev = this.dummy;
        this.dummy.next = this.dummy;
    }


    int get(int key){
        if(! map.containsKey(key)) return -1;
        Node node = map.get(key);
        // 移到最前面 先删除再插入头部
        this.remove(node);
        this.putFront(node);
        return node.value;

    }

    void put(int key, int value){
        // 存在则更新
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            this.remove(node);
            this.putFront(node);
            return;
        }
        // 不存在则插入头部
        Node newNode = new Node(key, value);
        this.map.put(key, newNode);
        this.putFront(newNode);

        // 如果超出了长度 则删除最后一个节点
        if(map.size() > this.capacity){
            Node lastNode = dummy.prev;
            map.remove(lastNode.key);
            this.remove(lastNode);

        }



    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void putFront(Node node){
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next = node;
        node.next.prev = node;
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

