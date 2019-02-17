package com.kyrie.concurrency.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/30.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing thread "+Thread.currentThread().getName());

    }


    public static void main (String[] args){
        Thread myThread = new Thread(new MyRunnable(), "myRunnable");

        myThread.start();

    }
}
