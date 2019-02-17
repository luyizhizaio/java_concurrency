package com.kyrie.concurrency.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/31.
 * 没有同步块，多个线程修改一个静态变量
 */
public class NotSynchronizedCounter5 implements Runnable {
    private static int counter = 0;

    public void run() {
        while(counter < 10) {
            System.out.println("["+Thread.currentThread().getName()+"] before: "+counter);
            counter++;
            System.out.println("["+Thread.currentThread().getName()+"] after: "+counter);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new NotSynchronizedCounter5(), "thread-"+i);
            threads[i].start();
        }
        for(int i=0; i<threads.length; i++) {
            threads[i].join();
        }
    }
}
