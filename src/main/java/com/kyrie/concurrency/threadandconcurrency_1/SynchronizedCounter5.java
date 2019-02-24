package com.kyrie.concurrency.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/31.
 * 有同步块，多个线程修改一个静态变量
 */
public class SynchronizedCounter5 implements Runnable {
    private static int counter = 0;

    public void run() {
        while (counter < 10) {
            synchronized (SynchronizedCounter5.class) {
                System.out.println("[" + Thread.currentThread().getName() + "] before: " + counter);
                counter++;
                System.out.println("[" + Thread.currentThread().getName() + "] after: " + counter);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new SynchronizedCounter5(), "thread-"+i);
            threads[i].start();
        }
        for(int i=0; i<threads.length; i++) {
            threads[i].join();
        }
    }
}
