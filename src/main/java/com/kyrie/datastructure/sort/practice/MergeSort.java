package com.kyrie.datastructure.sort.practice;

/**
 * 归并排序
 * 分：
 * 治：
 */
public class MergeSort {

  public static void main(String[] args) {
    int a[] =new int[]{5,4,7,9,3,8,2,1};
    sort(a);
    print(a);

  }
  public static void sort(int[] arr){
    sort(arr,0,arr.length - 1);
  }

  public static void sort(int[] arr, int low ,int high){
    if(low == high) {// 0 7;0 3;0 1;2 3;4 7;4 5;6 7
      return;
    }

    int mid = (high + low) / 2; //3;1;0;2;5;4;6
    //分
    sort(arr, low, mid); //0 3;0 1;0 0;2 2;4 5;4 4;6 6
    sort(arr, mid + 1, high); //1 1;2 3;3 3;4 7;5 5;6 7;7 7
    //治
    merge(arr, low, high);// 0 1;2 3;4 5;6 7

  }

  //合并两个有序数组
  public static void merge(int[] arr, int low ,int high){ //0 1

    int mid = (high + low) / 2;//0

    int[] tmp = new int[high - low +1];

    int k = 0;
    int p1= low;
    int p2 = mid+1;

    while(p1<=mid && p2<=high){
      tmp[k++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
    }

    while(p1 <= mid){
      tmp[k++] = arr[p1++];
    }

    while(p2 <= high){
      tmp[k++] = arr[p2++];
    }

    for (int i = 0; i < tmp.length; i++) {
      arr[low + i] = tmp[i];
    }

  }

  public static void print(int a[]){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }

}
