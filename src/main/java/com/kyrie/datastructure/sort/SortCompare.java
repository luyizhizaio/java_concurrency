package com.kyrie.datastructure.sort;

import org.apache.commons.lang3.time.StopWatch;

/**
 * Created by tend on 2019/12/24.
 * 算法执行时间比较
 */
public class SortCompare {

    public static double time(String alg,Comparable [] a){
        StopWatch sw = new StopWatch();
        sw.start();
        if("Insertion".equals(alg)) Insertion.sort(a);
        if("Selection".equals(alg)) Selection.sort(a);

        return sw.getNanoTime();
    }
    public static double timeRadomInput(){


        return 0.0;
    }


    public static void main(String [] args){
        Integer[] arr = {14,2,93,85,11,64,96,12,2,4};
        System.out.println(time("Insertion", arr));
        System.out.println(time("Selection", arr));

    }

}
