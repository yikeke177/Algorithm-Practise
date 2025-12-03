package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 懒汉式 线程不安全
 * @date: 2025/12/3 15:26
 * @version: 1.0
 * 当有多个线程同时获取单例对象时，可能会同时进入if代码块，导致创建多次实例对象。
 */
public class SingletonDemo3{

    private static SingletonDemo3 instance;

    // 私有构造方法，外部无法实例化
    private SingletonDemo3(){
        System.out.println("构造单例");
    }

    public static SingletonDemo3 getInstance(){
        if(instance == null){
            instance = new SingletonDemo3();
        }
        return instance;
    }

    public static void main(String[] args){
        // 获取单例

        SingletonDemo3 instance = SingletonDemo3.getInstance();

    }
}

