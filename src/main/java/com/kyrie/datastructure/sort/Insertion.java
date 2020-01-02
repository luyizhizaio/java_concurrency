package com.kyrie.datastructure.sort;

/**
 * 2.插入排序
 * Created by Kyrie on 2019/1/13.
 * 思想：整理桥牌，无序的元素插入有序的数组
 */
public class Insertion extends BaseSort {

    public static void main(String[] args){

        Integer[] arr = {93,93,85,11,64,96,12,4};
        sort(arr);
        show(arr);


    }

    public static void sort(Comparable[] cp){
        int N = cp.length;
        for(int i =1 ; i< N  ; i++){
            for(int j = i ; j > 0; j-- ){
                //判断后一个是否小于前一个，如果小于则交换
                if(less(cp[j],cp[j-1])) exch(cp ,j,j-1);
            }
        }

    }


}
