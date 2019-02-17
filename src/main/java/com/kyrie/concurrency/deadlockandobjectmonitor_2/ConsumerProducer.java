package com.kyrie.concurrency.deadlockandobjectmonitor_2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Created by tend on 2018/8/1.
 * The following code demonstrates how the wait() and notify() mechanism can be used to let the consumer threads wait for new work that is pushed into a queue from some producer thread:
 *
 */


public class ConsumerProducer {
    private static final Queue<Integer> queue = new ConcurrentLinkedQueue();
    private static final long startMillis = System.currentTimeMillis();

    public static class Consumer implements Runnable {

        public void run() {
            while (System.currentTimeMillis() < (startMillis + 10000)) {
                synchronized (queue) {
                    try {
                        queue.wait();//等待生产者放好资源，被叫醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!queue.isEmpty()) {
                    Integer integer = queue.poll();
                    System.out.println("[" + Thread.currentThread().getName() + "]: " + integer);
                }
            }
        }
    }

    public static class Producer implements Runnable {

        public void run() {
            int i = 0;
            while (System.currentTimeMillis() < (startMillis + 10000)) {
                queue.add(i++);
                synchronized (queue) {
                    System.out.println("[" + Thread.currentThread().getName() + "]: " + (i-1));
                    queue.notify();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //叫醒所有等待的线程，结束程序
            synchronized (queue) {
                queue.notifyAll();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] consumerThreads = new Thread[5];
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i] = new Thread(new Consumer(), "consumer-" + i);
            consumerThreads[i].start();
        }
        Thread producerThread = new Thread(new Producer(), "producer");
        producerThread.start();
        for (int i = 0; i < consumerThreads.length; i++) {
            consumerThreads[i].join();
        }
        producerThread.join();
    }
}