package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2019/1/13.
 */
public class SelectionSort extends BaseSort {

    public static void main(String[] args){

        Integer [] arr = {14,2,93,85,11,64,96,12,4};
        sort(arr);

        show(arr);
    }

    /**
     * 简单选择排序
     */
    public static void sort(Comparable[] a){

        int N = a.length;

        for(int i =0; i< N ;i++){
            int min = i;
            for(int j = i+1 ;j<N ;j++)
                if(less(a[j],a[min])) min = j;
            exch(a,i,min);
        }

    }

}
