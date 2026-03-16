package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 懒汉式（线程安全，双重校验锁DCL+volatile）
 * @date: 2025/12/3 16:09
 * @version: 1.0
 */

public class SingletonDemo6{

    private static volatile SingletonDemo6 instance;

    // 私有构造方法，外部无法实例化
    private SingletonDemo6(){
        System.out.println("构造单例");
    }

    public static SingletonDemo6 getInstance(){
        if(instance == null){
            synchronized(SingletonDemo6.class){
                if(instance == null){
                    instance = new SingletonDemo6();
                }
            }
        }
        return instance;

    }

    public static void main(String[] args){
        // 获取单例

        SingletonDemo6 instance = SingletonDemo6.getInstance();

    }
}



