package com.kyrie.deadlockandobjectmonitor_2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by tend on 2018/8/1.
 * 出现死锁
 */
public class SynchronizedAndWait {
    private static final Queue<Integer> queue = new ConcurrentLinkedQueue();

    //获得对象锁，才能执行该方法。
    public synchronized Integer getNextInt() {
        Integer retVal = null;
        while (retVal == null) {
            synchronized (queue) {
                try {
                    System.out.println("getNextInt "+Thread.currentThread().getName());
                    queue.wait();
                    System.out.println("getNextInt wait after "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                retVal = queue.poll();
            }
        }
        return retVal;
    }

    //获得对象锁，才能执行该方法。
    public synchronized void putInt(Integer value) {
        synchronized (queue) {
            queue.add(value);
            queue.notify();
            System.out.println("putInt  "+value +"  " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedAndWait queue = new SynchronizedAndWait();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    queue.putInt(i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Integer nextInt = queue.getNextInt();
                    System.out.println("Next int: " + nextInt);
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}