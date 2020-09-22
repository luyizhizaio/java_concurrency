package com.kyrie.concurrency.forkjoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by tend on 2020/9/18.
 */
public class ForkJoinTest {

    @Test
    public void FJTest() {
        Instant start = Instant.now();
        //create pool
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> calculate = new ForkJoinSumCalculate(0,100000000L);

        //execute
        Long num = pool.invoke(calculate);

        System.out.println(num);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

    }

    /**
     * jdk1.8新特性test方法
     * JDK8 对 Fork/Join 的优化
        JDK8 对 Fork/Join 的优化：主要是让 Fork/Join 使用起来更加方便。对 Fork/Join 进行了封装，简化使用方式。
        对于 JDK8 对 Fork/Join 的底层优化，这里不进行分析。
     */
    @Test
    public void test2(){


        Instant start = Instant.now();

        Long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//1536-8118

    }


}

class ForkJoinSumCalculate extends RecursiveTask<Long>{



    private long start;
    private long end;

    private static final long THURSHOLDS = 10; //阈值


    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;
        //小于阈值开始相加
        long sum = 0l;
        if(length <=THURSHOLDS){

            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        } else {
            long mid = (start+ end)/2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
            left.fork();//拆分，同时压入线程队列


            ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid+1,end);
            right.fork();//拆分

            return left.join() + right.join();//合并
        }

    }
}
