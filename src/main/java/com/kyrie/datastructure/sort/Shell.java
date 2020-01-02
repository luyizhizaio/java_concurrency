package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2020/1/2.
 * 希尔排序:对插入排序的改进。使用插入排序让数组中间隔为h的元素有序，减小h至1，则数组有序。
 */
public class Shell extends BaseSort {

    public static void main(String[] args){

        Integer[] arr = {14,2,93,85,11,64,96,12,2,4};
        sort(arr);
        show(arr);
    }

    public static void sort(Comparable[] cp){
        int N = cp.length;

        int h =1;

        while(h < N/3) h = h *3 +1; //1,4,13,121,364,...
        while(h >=1) {

            for (int i = h; i < N; i++) {
                for (int j = i; j >=h ; j -= h) {
                    //判断后一个是否小于前一个，如果小于则交换
                    if (less(cp[j], cp[j - h])) exch(cp, j, j - h);
                }
            }
            h = h/3;
        }

    }


}
