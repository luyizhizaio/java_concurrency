package com.kyrie.datastructure.sort;

/**
 * 交换类排序
 * Created by Kyrie on 2019/1/13.
 */
public class InsertSort {

    public static void main(String[] args){

        int[] arr = {93,85,11,64,96,12,4};
        insertSort(arr);

        shellSort(arr);


    }

    /**
     * 直接插入排序
     * @param arr
     */
    public static void insertSort(int[] arr){

        int  i,j;
        int temp;
        for (i =1 ;i<arr.length;++i){
            temp=arr[i];
            j = i-1;

            while(j>=0 && temp< arr[j]){
                arr[j+1] =arr[j];
                --j;
            }
            arr[j+1] = temp;
        }

        print(arr);

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
