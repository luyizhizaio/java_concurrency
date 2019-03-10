package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2019/1/13.
 */
public class ExchangeSort {

    public static void main(String[] args){

        int[] arr = {14,2,93,85,11,64,96,12,4};
        quickSort(arr,0,arr.length-1);

        bubbleSort(arr);
    }


    /**
     * ¿ìËÙÅÅĞò
     * @param arr
     */
    public static void quickSort(int [] arr, int low ,int high){

        int temp;
        int i = low,j = high;
        if(low < high){

            temp = arr[low]; //ÊàÖá

            while(i <j){
                while(j>i && arr[j]>= temp) --j; //´ÓÓÒÏò×óÉ¨Ãè
                if(i<j){
                    arr[i]=arr[j];
                    ++i;
                }
                while(i<j && arr[i] < temp) ++i; //´Ó×óÍùÓÒÉ¨Ãè
                if(i<j){
                    arr[j]=arr[i];
                    --j;
                }
            }
            arr[i] = temp;
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);

        }

    }

    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * Ã°ÅİÅÅĞò
     * @param arr
     */
    public static void bubbleSort(int [] arr){

        int i,j,flag; int temp;
        for(i = arr.length - 1; i>=1 ; --i){
            flag = 0;
            for(j=1;j<=i;++j){
                if(arr[j-1] >arr[j]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    flag= 1;
                }
                if(flag ==0){
                    print(arr);
                    return;
                }
            }
        }



    }
}
