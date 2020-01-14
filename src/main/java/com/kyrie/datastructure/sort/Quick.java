package com.kyrie.datastructure.sort;

import com.kyrie.datastructure.utils.StdRandom;

/**
 * 快排
 * Created by tend on 2020/1/14.
 */
public class Quick extends BaseSort {

    public static void sort(Comparable [] a){

        //StdRandom.shuffle(a);
        sort(a , 0,a.length -1);
    }


    public static void sort(Comparable[] a , int lo,int hi){

        if(hi <= lo) return;

        int j = partition(a, lo,hi);//先切分
        sort(a,lo,j-1);//排序左半边
        sort(a,j+1, hi);//排序右半边



    }

    public static int partition(Comparable[] a,int lo ,int hi){

        Comparable k = a[lo];


        int i = 0;
        int j = hi + 1;

        while(true){

            while(less(a[++i],k)) if(i == hi) break;// 左边大于中间的数不执行循环
            while(less(k,a[--j])) if(j == lo) break;// 有边小于中间的数不执行循环
            if(i >=j ) break;
            exch(a,i,j); //两个元素交换
        }

        exch(a,lo,j);//j是分割点，j的左边小于j的元素，右边是大于j的元素。
        return j;

    }


    public static void main(String [] args){

        Integer [] a = {7,5,1,6,3};

//        partition(a,0);
        sort(a);
        show(a);

    }

}
