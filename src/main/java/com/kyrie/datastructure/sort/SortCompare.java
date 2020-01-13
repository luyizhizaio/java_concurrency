package com.kyrie.datastructure.sort;

import com.kyrie.datastructure.utils.StdOut;
import com.kyrie.datastructure.utils.StdRandom;
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
        if("Merge".equals(alg)) Merge.sort(a);
        if("Shell".equals(alg)) Shell.sort(a);

        return sw.getNanoTime();
    }
    public static double timeRadomInput(String alg ,int N ,int T){

        //使用算法将T个长度为N的数组排序
        double total = 0.0;
        Double [] a = new Double [N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total  += time(alg,a);
        }

        return total;
    }


    public static void main(String [] args){
       /* Integer[] arr = {14,2,93,85,11,64,96,12,2,4};
        System.out.println(time("Insertion", arr));
        System.out.println(time("Selection", arr));*/

        double t1 = timeRadomInput("Insertion" ,10000 ,1000);
        double t2 = timeRadomInput("Selection" ,10000 ,1000);
        double t3 = timeRadomInput("Merge" ,10000 ,1000);
        double t4 = timeRadomInput("Shell" ,10000,1000);

        StdOut.printf("Insertion:" + t1 + "\n");
        StdOut.printf("Selection:" + t2 + "\n");
        StdOut.printf("Merge:" + t3 + "\n");
        StdOut.printf("Shell:" + t4 + "\n");


    }

}
