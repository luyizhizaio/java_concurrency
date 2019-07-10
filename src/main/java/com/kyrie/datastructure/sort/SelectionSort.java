package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2019/1/13.
 */
public class SelectionSort {

    public static void main(String[] args){

        int[] arr = {14,2,93,85,11,64,96,12,4};
        selectSort(arr);
    }



    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * 简单选择排序
     */
    public static void selectSort(int[] arr){

        int i,j,k;
        int temp;
        for(i = 0;i<arr.length;++i){
            k =i;
            //从无序序列中挑出一个最小的关键字
            for(j = i+1; j<arr.length;++j)
                if(arr[k] >arr[j])
                    k=j;
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }

        print(arr);

    }



}
