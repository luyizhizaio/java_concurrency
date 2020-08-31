package com.kyrie.datastructure.sort.quicksort;

import java.util.Arrays;

public class QuickSort {


  public static void main(String[] args) {

    int[] arr = {3,-2,1,5,4,6};
    sort(arr, 0 ,arr.length -1);

    System.out.println(Arrays.toString(arr));

  }


  public static  void sort(int [] a ,int left ,int right){

    int mid = a[(left +right)/2];

    int temp=0;
    int l = left, r = right;
    while (l < r){

      while (a[l] < mid){
        l++;
      }

      while (a[r] > a[mid]){
        r--;
      }

      temp=a[l];
      a[l] = a[r];
      a[r] = temp;

      if(left >= right){
        break;
      }
    }





  }

}
