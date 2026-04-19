package com.yike.algorithms.others.juc;

/**
 * @author jyk
 * @description 三个线程交替打印1~100
 * @date 2026/4/8 16:43
 */
public class ThreeThreadPrint1To100 {
    /**
     * 对3取模来判断当前是否是自己打印
     * 共享变量cnt，表示当前需要打印的数字
     * 创建3个任务 分别打印cnt（如果满足条件）
     * 定义一把锁
     * 创建一个共享变量cnt
     *
     */

    static final int MAX = 100;
    static final Object LOCK = new Object();
    static volatile int cnt = 1;

    public static void main(String[] args) {
        // 创建三个线程

        Thread thread0 = new Thread(new PrintNumTask(0));
        Thread thread1 = new Thread(new PrintNumTask(1));
        Thread thread2 = new Thread(new PrintNumTask(2));


        thread0.start();
        thread1.start();
        thread2.start();
    }



    // 创建任务类
    static class PrintNumTask implements Runnable{
        private int index;
        // 构造函数
        PrintNumTask(int idx){
            this.index = idx;
        }

        @Override
        public void run() {
            // 线程的任务
            // 如果当前cnt符合条件就打印 不符合就让出锁 结束后唤醒其他线程

            while(cnt <= MAX){

                // 加锁
                synchronized (LOCK){
                    while(cnt % 3 != this.index){

                        // 不符合条件释放锁
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    // 符合条件则打印 并通知其他线程
                    if(cnt <= MAX){

                        System.out.println(Thread.currentThread() + " print: " + cnt);

                        cnt ++;
                        LOCK.notifyAll();
                    }

                }



            }
        }
    }

}
