package com.kyrie.datastructure.sort;

/**
 * 交换类排序:
 * Created by Kyrie on 2019/1/13.
 */
public class InsertSort extends BaseSort {

    public static void main(String[] args){

        Integer[] arr = {93,85,11,64,96,12,4};
        insertSort(arr);
        show(arr);

    }

    /**
     * 直接插入排序
     * @param a
     */
    public static void insertSort(Comparable[] a){

        int N = a.length;
        for(int i =1; i<N;i++){
            for(int j=i ;j>0 && less(a[j],a[j-1]);j--)
                exch(a,j,j-1);
        }

    }

    /**
     *希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr){

        int section = arr.length / 2;
        int j ;
        int temp;
        while(section >=1) {
            for(int i = section; i < arr.length; i++){
                temp = arr[i];
                j = i - section;
                while(j >= 0 && arr[j] > temp){
                    arr[j+section] = arr[j];
                    j = j -section;
                }
                arr[j+section] = temp;
            }
            section/=2;
        }
        print(arr);

    }


    public static void print(int [] arr){
        for(int x=0; x< arr.length ;x++){
            System.out.print(arr[x] + " , ");
        }
        System.out.println();
    }

}
