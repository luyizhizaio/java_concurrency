package com.kyrie.datastructure.sort;

/**
 * Created by tend on 2017/6/15.
 */
public class BubbleSort {

    public  static void main(String[]args){


        int a[] = {3,7,5,4};
        BubbleSort bs = new BubbleSort();

        System.out.print("≥ı º÷µ£∫");
        bs.print(a);
        bs.bubbleSort(a, a.length);
        System.out.print("≈≈–Ú∫Û£∫");
        bs.print(a);


    }


    void bubbleSort(int a[], int n){
        for(int i =0 ; i< n-1; ++i) {
            for(int j = 0; j < n-i-1; ++j) {
                if(a[j] > a[j+1])
                {
                    int tmp = a[j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = tmp;
                }
            }
        }
    }

    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
