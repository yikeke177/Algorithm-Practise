package com.yike.algorithms.others.juc;

/**
 * @author jyk
 * @description 两个线程交替打印0-100
 * @date 2026/4/8 16:41
 */
public class TwoThreadPrint1To100 {
    // 共享变量
    private static volatile int cnt = 1;
    private static final int MAX = 100;

    // 锁
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 两个线程轮流打印1~100
        // 线程1打印奇数，线程2打印偶数
        // 两个线程同时访问当前计数值，如果是自己打印的就打印，如果不是就释放锁，让给另一个线程打印

        // 创建两个任务，分别是打印偶数和打印奇数
        Thread threadOdd = new Thread(new PrintNumTask(1));
        Thread threadEven = new Thread(new PrintNumTask(0));

        // 启动两个线程
        threadOdd.start();
        threadEven.start();

        // 不加也行 main函数先退出，但java进程不会结束，会等待两个线程都结束后才结束。
        threadOdd.join();
        threadEven.join();
//        System.out.println("main exit!");



    }

    static class PrintNumTask implements Runnable{

        // 构造函数初始化是打印偶数还是奇数
        private int index;

        PrintNumTask(int idx){
            this.index = idx;
        }

        @Override
        public void run() {
            // 如果当前计数%2==index，符合要求，可以打印。否则阻塞等待让出锁，等待被唤醒。
            while(cnt <= MAX){

                // 加锁
                synchronized (LOCK){
                    while(cnt % 2 != this.index){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }

                    // 符合要求 可以打印
                    if(cnt <= MAX){
                        System.out.println(Thread.currentThread().getName() + " print: " +  cnt);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        cnt++;
                        // 唤醒其他阻塞线程
                        LOCK.notifyAll();
                    }

                }
            }

        }
    }

}
