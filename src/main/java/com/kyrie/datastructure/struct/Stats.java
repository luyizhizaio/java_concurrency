package com.kyrie.datastructure.struct;

import com.kyrie.datastructure.struct.linkedlist.Bag;
import com.kyrie.datastructure.utils.StdIn;
import com.kyrie.datastructure.utils.StdOut;

/**
 * Created by tend on 2019/9/23.
 * Bag的使用
 */
public class Stats {


    public static void main(String[] args) {

        Bag<Double> numbers = new Bag<Double>();
        while(!StdIn.isEmpty())
            numbers.add(StdIn.readDouble());
        int N = numbers.size();

        double sum = 0.0;
        for(double x :numbers){
            sum += x;
        }
        double  mean = sum/N;

        sum =0.0;
        for(double x : numbers)
            sum+=(x - mean)*( x - mean);

        double std = Math.sqrt(sum);

        StdOut.println("mean:"+mean);
        StdOut.println("std:"+std);

    }
}
