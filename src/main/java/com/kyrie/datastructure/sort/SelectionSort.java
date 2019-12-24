package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2019/1/13.
 * 选择排序思想：选择数组中最小的元素与 索引为0，1，2，3...换位置
 */
public class SelectionSort extends BaseSort {

    public static void main(String[] args){

        Integer[] arr = {14,2,93,85,11,64,96,12,2,4};
        sort(arr);
        show(arr);
    }


    public static void sort(Comparable[] cp){

        for(int i=0 ; i<cp.length ; i++){
            int  min = i;
            for(int j=i+1 ; j< cp.length ; j++) {
                if (less(cp[j],cp[min])) min = j; //选择值最小的index
            }
            exch(cp , i ,min);
        }


    }

}
