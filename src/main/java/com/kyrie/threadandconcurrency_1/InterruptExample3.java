package com.kyrie.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/31.
 * 中断sleeping线程（叫醒线程）
 */
public class InterruptExample3 implements Runnable {

    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }
        while(!Thread.interrupted()) { //测试当前线程是否已经中断。
            // do nothing here
        }
        System.out.println("["+Thread.currentThread().getName()+"] Interrupted for the second time.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new InterruptExample3(), "myThread");
        myThread.start();

        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();//叫醒线程

        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
    }
}