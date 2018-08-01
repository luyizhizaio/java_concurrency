package com.kyrie.threadandconcurrency_1;

import java.util.Random;

/**
 * Created by tend on 2018/7/31.
 * 主线程等待所有者子线程终止，
 */
public class JoinExample4 implements Runnable {
    private Random rand = new Random(System.currentTimeMillis());

    public void run() {
        //simulate some CPU expensive task
        for(int i=0; i<100000000; i++) {
            rand.nextInt();
        }
        System.out.println("["+Thread.currentThread().getName()+"] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new JoinExample4(), "joinThread-"+i);
            threads[i].start();
        }
        for(int i=0; i<threads.length; i++) {
            threads[i].join();//等待该线程终止。
        }
        System.out.println("["+Thread.currentThread().getName()+"] All threads have finished.");
    }
}
