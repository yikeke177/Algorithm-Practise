package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 饿汉式 （静态代码块 天然线程安全）
 * @date: 2025/12/3 15:20
 * @version: 1.0
 */
public class SingletonDemo2{

    private static final SingletonDemo2 instance;

    static{
        instance = new SingletonDemo2();
    }

    // 私有构造器，禁止其他类构造对象
    private SingletonDemo2(){
        System.out.println("构造单例对象...");
    }

    public static SingletonDemo2 getInstance(){
        return instance;
    }


    public static void main(String[] args){
        // 获取单例
        SingletonDemo2 instance = SingletonDemo2.getInstance();

    }

}

