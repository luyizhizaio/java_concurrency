package com.kyrie.datastructure.sort;

/**
 * 二路归并排序
 * Created by Kyrie on 2019/1/13.
 */
public class MergeSort {

    public static void main(String[] args){
        int[] arr = {14,2,93,85,11,64,96,12,4};
        mergeSort(arr, 0,arr.length -1);
    }

    public static void mergeSort(int arr[],int low,int high){

        if(low < high){
            int mid = (low + high) /2;
            //左边
            mergeSort(arr,low ,mid);
            //右边
            mergeSort(arr,mid+1,high);
            //左右归并
            merge(arr,low,mid,high);
        }

       // print(arr);


    }


    /**
     * 合并两个有序 “序列”
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int [] a,int low,int mid,int high){

        int [] temp = new int[high - low +1];
        int i =low;
        int j = mid +1;
        int k = 0;

        while(i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k++] =a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while(i <= mid){
            temp[k++] = a[i++];
        }
        while(j<=high){
            temp[k++] = a[j++];
        }
        for(int k2 = 0; k2<temp.length;k2++){
            a[k2+low] = temp[k2];
        }
    }

    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

}
