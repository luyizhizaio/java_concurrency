package com.kyrie.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by tend on 2020/9/18.
 */
public class ForkJoinTest {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinSumCalculate<Long> calculate = new ForkJoinSumCalculate(0,1000000);

        pool.invoke(calculate);



    }


}

class ForkJoinSumCalculate extends RecursiveTask<Long>{



    private long start;
    private long end;

    private static final long THURSHOLDS = 10000; //阈值


    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;
        //小于阈值开始相加
        long sum = 0;
        if(length <=THURSHOLDS){

            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        } else {
            long mid = (start+ end)/2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, mid);
            left.fork();//拆分


            ForkJoinSumCalculate right = new ForkJoinSumCalculate(mid+1,end);
            left.fork();//拆分

            return left.join() + right.join();
        }

    }
}
