package com.kyrie.datastructure.sort;

/**
 * Created by tend on 2020/1/15.
 * 三向切分快速排序：用于处理大量重复元素数组排序
 */
public class Quick3Way extends BaseSort {



    public static void sort(Comparable[] a){

        sort(a,0,a.length -1);

    }


    public static void sort(Comparable[] a,int lo ,int hi ){

        if(lo >= hi) return;

        int lt =lo, i = lo+1, gt = hi ;

        Comparable v =a[lo] ;

        while(i<=gt){

            if(less(a[i],v)) exch(a,lt++ ,i++);
            else if(less(v,a[i])) exch(a,gt-- ,i);
            else  i++;
        }
        sort(a,lo,lt -1);
        sort(a,gt +1,hi);

    }

    public static void main(String[] args) {

        Integer [] a = {3,4,1,2,3,4,5,6,7,7,8,9,2,4,5,7,5,1,6,3};

//        partition(a,0);
        sort(a);
        show(a);



    }



}
