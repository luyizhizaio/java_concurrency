package com.kyrie.datastructure.sort.practice;

/**
 * Created by tend on 2019/7/16.
 */
public class QuickSort2 {


    public static void main(String[] args) {

        int[] arr = {4,1,5,6,23,1,34,56,3,7,3,4,7,8,3,2,4,6,7,89,97,6,44,22,454,776,4,3,2,12};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：");
        print(arr);

    }


    public static void quickSort(int[] arr , int low, int high){
        if(low < high){
            int mid = getMid(arr,low,high);
            quickSort(arr,low ,mid-1);
            quickSort(arr,mid+1,high);
        }
    }


    public static int getMid(int[] arr , int low, int high){
        print(arr);
        int k = arr[low];
        while(low < high) {
            while (k <= arr[high] && low < high) { //从右向左， 找第一个小于 k的数，小于就跳出循环
                high--;
            }
            arr[low++] = arr[high];

            while (k > arr[low] && low < high) { //从左向右， 找第一个大于k的数，大于就跳出循环
                low++;
            }

            arr[high--] = arr[low];
        }
        arr[low] =k;
        return low;

    }
    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
