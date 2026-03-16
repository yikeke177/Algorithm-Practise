package com.yike.algorithms.others.singletons;

/**
 * @author: jyk
 * @description: 懒汉式（懒加载，内部类，天然线程安全）
 * @date: 2025/12/3 15:58
 * @version: 1.0
 */
public class SingletonDemo5{

    private static class SingletonHolder{
        private static final SingletonDemo5 instance = new SingletonDemo5();

    }

    private SingletonDemo5(){
        System.out.println("实例化");
    }

    public static SingletonDemo5 getInstance(){
        return SingletonHolder.instance;
    }


    public static void main(String[] args){
        SingletonDemo5 instance = SingletonDemo5.getInstance();
    }
}
