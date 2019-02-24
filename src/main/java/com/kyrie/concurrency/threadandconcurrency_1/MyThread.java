package com.kyrie.concurrency.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/30.
 */
public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Executing thread: "+Thread.currentThread().getName());

    }

    public static void main (String[] args){
        MyThread myThread = new MyThread("myThread");

        myThread.start();
    }
}
