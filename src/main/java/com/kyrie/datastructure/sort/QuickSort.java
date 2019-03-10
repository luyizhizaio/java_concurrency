package com.kyrie.datastructure.sort;

/**
 * Created by tend on 2017/6/15.
 */
public class QuickSort {

    public  static void main(String[]args){


        int a[] = {3,7,5,4};
        QuickSort qs = new QuickSort();
        System.out.print("≥ı º÷µ£∫");
        qs.print(a);
        qs.quickSort(a,0,a.length-1);
        System.out.print("≈≈–Ú∫Û£∫");
        qs.print(a);


    }

    private void quickSort(int[] a ,int low,int high){
        print(a);
        if(low < high){
            int middle =getMiddle(a, low ,high);
            quickSort(a,0,middle-1);
            quickSort(a, middle + 1, high);
        }
    }

    public int getMiddle(int[] a , int low, int high){

        int key = a[low];
        while (low < high){
            while(low <high && a[high] >=key){
                high --;
            }
            a[low] =a[high];
            while (low < high && a[low] <=key){
                low ++;
            }
            a[high] = a[low];
        }
        a[low] =key;
        return low;

    }
    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
