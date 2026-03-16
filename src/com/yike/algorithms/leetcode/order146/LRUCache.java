package com.yike.algorithms.leetcode.order146;


import java.util.HashMap;


/*
LRU(least recently used) 最近最少使用
缓存大小是固定的，每次put可能插入新值，也可能是更新原有的值。
get操作后的元素会变成最近使用的。

整体思路：
哈希表 + 双向链表
哈希表支持O(1)的查询速度
队列支持先进先出，但由于需要更新最近最少使用，队列的增删效率是O(n)的，也不适合
双向链表既可以支持先进先出，也增删的效率也是O(1)的

 */

/**
 * 结点类
 */
class Node{
    public int key;
    public int value;
    public Node prev = null;
    public Node next = null;

    public Node(){
        this.key = -1;
        this.value = -1;
        this.prev = null;
        this.next = null;
    }
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public Node(int key, int value, Node prev, Node next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

}


/**
 * @author: jyk
 * @description: 146. LRU 缓存
 * @date: 2025/12/2 18:46
 * @version: 1.0
 */
class LRUCache {
    // 哈希表 + 双向链表
    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head = null;
    private Node tail = null;
    private int size;


    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        head.next = this.tail;
        tail.next = this.head;
    }


    public int get(int key){
        // 先查map看是否存在
        Node node = map.get(key);
        // 否 则返回-1
        if(node == null)return -1;

        //是 则删除并重新头插入 最后返回值
        delNode(node);
        // size不变
        //
        addToHead(node);
        return node.value;


    }

    public void put(int key, int value){
        // 查map看是否存在，
        Node node = map.get(key);
        if(node != null){
            // 如果存在则直接更改值信息并移动到链表头
            // 不改变size
            node.value = value;
            delNode(node);
            addToHead(node);
        }else {
            // 不存在key 则先检查map的size()是否已经>=capacity
            if(size >= capacity){
                // 是 则先删除尾部再插入头
                map.remove(tail.prev.key);
                delNode(tail.prev);

                size --;
            }
            // new一个新node
            Node newNode = new Node(key, value);
            // 否 则直接插入链表头
            addToHead(newNode);
            // 插入map
            map.put(key, newNode);
            // size++
            size ++;

        }
    }


    private void delNode(Node node){

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }



    private void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
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
