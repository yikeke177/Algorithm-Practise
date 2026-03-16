package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 懒汉式 synchronized线程安全
 * @date: 2025/12/3 15:30
 * @version: 1.0
 */
public class SingletonDemo4{

    private static SingletonDemo4 instance;

    // 私有构造方法，外部无法实例化
    private SingletonDemo4(){
        System.out.println("构造单例");
    }

    public static synchronized SingletonDemo4 getInstance(){
        if(instance == null){
            instance = new SingletonDemo4();
        }
        return instance;
    }

    public static void main(String[] args){
        // 获取单例

        SingletonDemo4 instance = SingletonDemo4.getInstance();

    }
}


