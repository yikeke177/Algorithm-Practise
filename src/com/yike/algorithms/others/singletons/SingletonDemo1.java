package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 懒汉式单例（天然线程安全）
 * @date: 2025/12/3 15:11
 * @version: 1.0
 * 由于static静态成员变量会在类加载时唯一初始化，所以是唯一的
 * 由于在类加载时，jvm会保证多线程加载类时，只能有一个线程加载类，其他线程会阻塞等待，所以天然保证类线程安全
 */
public class SingletonDemo1 {

    private static final SingletonDemo1 instance = new SingletonDemo1();


    // 私有构造器，禁止其他类构造对象
    private SingletonDemo1(){
        System.out.println("构造单例对象...");
    }

    public static SingletonDemo1 getInstance(){
        return instance;
    }



    public static void main(String[] args){
        // 获取单例
        SingletonDemo1 instance = SingletonDemo1.getInstance();

    }
}
