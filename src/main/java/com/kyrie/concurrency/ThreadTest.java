package com.kyrie.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tend on 2020/9/22.
 */
public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {

//1. 创建线程池
        ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        AtomicBoolean executable= new AtomicBoolean(true);

        for (int i = 0; i <10 ; i++) {

            final int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    for (int j = 0; j <1000 ; j++) {
                        if(executable.get()){
                            System.out.println(finalI +" "+Thread.currentThread().getName()+ ":"+j);
                            if(Thread.currentThread().isInterrupted()){
                                executable.set(false);
                                break;
                            }
                            if(j == 1){
                                Thread.currentThread().interrupt();
                            }
                        }


                    }
                }
            };

            pool.execute(runnable);

        }

        // 允许核心线程池超时，超时时间为2s
        pool.setKeepAliveTime(30L, TimeUnit.SECONDS);
        pool.allowCoreThreadTimeOut(true);

    }

}
