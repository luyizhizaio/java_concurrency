package com.kyrie.datastructure.sort.practice;

public class MergeSort {

  public static void main(String[] args) {
    int a[] =new int[]{23,46,0,8,11,18};

    sort(a);

    print(a);
    int tmp [] = new int[a.length];
  }

  public static void sort(int[] arr){

  }


  public static void sort(int[] arr, int low ,int high,int[] tmp){

      if(low != high){
        int mid = (high + low) / 2;
        sort(arr, low, mid, tmp);
        sort(arr, mid + 1, high, tmp);
        merge(arr, low, high, tmp);
      }



  }

  public static void merge(int[] arr, int low ,int high,int[] tmp){

    int mid = (high + low) / 2;

    int l = low ,h = high;
    while(l<h){
      while(l< mid){
        if(arr[l] > arr[mid+1]){

          tmp[l] = arr[mid+1];

        }
        }

    }


  }


  public static void print(int a[]){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }

}
