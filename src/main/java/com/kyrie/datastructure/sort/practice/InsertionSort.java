package com.kyrie.datastructure.sort.practice;

public class InsertionSort {

  public static void main(String[] args) {
    //int[] arr = {3,2,5};
    int arr[] =new int[]{5,4,7,9,3,8,2,1};
    sort(arr);
    print(arr);
  }

  public static void sort(int[] arr){

    for (int i = 1; i < arr.length ; i++) {

      int insertvalue = arr[i];
      int insertIndex =i-1;//有序数字的上界；i无序数字的下届

      //没找插入位置
      while(insertIndex>=0 &&  insertvalue <arr[insertIndex]){
        arr[insertIndex +1] = arr[insertIndex];
        insertIndex--;
      }
      //找到插入位置
      arr[insertIndex +1] =insertvalue;
    }
  }


  public static void sort2(int[] arr){

    for (int i = 1; i <arr.length ; i++) {

      int j =i-1;
      int tmp = arr[i];
      while(j>=0) {
        if(j==0){
          if (tmp < arr[j]) {
            arr[j+1] = arr[j];
            arr[j] = tmp;
            break;
          }
        }
        if (tmp > arr[j]) {
          arr[j + 1] = tmp;
          break;
        } else {
          arr[j + 1] = arr[j];
        }
        j--;
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
