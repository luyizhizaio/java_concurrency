package com.kyrie.datastructure.sort.practice;

/**
 * Created by tend on 2019/8/6.
 */
public class QuickSort3 {

    public static void main(String [] args){
        int [] arr = {3,24,12,5,43,2};
        quickSort(arr,0,arr.length - 1);
        print(arr);

    }




    public static void quickSort(int [] arr, int low , int high){
        if(low < high){
            int mid = getMid(arr,low,high);
            quickSort(arr,low,mid -1);
            quickSort(arr,mid + 1,high);
        }

    }


    public static int getMid(int [] arr, int low ,int high){

        int k = arr[low]; //k为中间值
        while(low < high){

            while(low < high && k <= arr[high]){ //找出小于k的值往左放
                high --;
            }
            arr[low] = arr[high];

            while(low < high && arr[low] < k ){ //找出大于k的值往右放
                low++;
            }
            arr[high] = arr[low];

        }
        arr[low] = k;
        return low;
    }

    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
