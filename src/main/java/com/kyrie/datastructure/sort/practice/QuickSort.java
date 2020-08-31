package com.kyrie.datastructure.sort.practice;

public class QuickSort {

  public static void main(String[] args) {

//    int a[] =new int[]{4,2,6,5,3,1};
    int a[] =new int[]{23,46,0,8,11,18};

    sort(a, 0 ,a.length -1);

    print(a);


  }

  public static void sort(int[] arr, int low ,int high){

    if(low < high){
      int  mid = arr[(high + low)/2];
        int l = low, h = high;
      while(l < h){

        while( arr[h] > mid ){
          h --;
          if(arr[h] < mid) break;
        }

        while( arr[l] < mid ){
          l ++;
          if(arr[l] > mid) break;
        }

        if(l >= h) break;

        int tmp = 0;
        tmp = arr[h];
        arr[h] = arr[l];
        arr[l] = tmp;
      }

      sort(arr,low,l);
      sort(arr,l+1, high);

    }

  }

  public static void print(int a[]){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }
}
