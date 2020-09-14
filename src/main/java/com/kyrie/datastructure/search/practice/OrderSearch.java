package com.kyrie.datastructure.search.practice;

/**
 * 数组顺序查找
 */
public class OrderSearch {


 public static void main(String[] args){
    int value = 4;
    int[] arr = {1,23,4,5,6,3,3};
    int index =search(arr,value);
    System.out.println(index);
  }


  public static int search(int arr[], int value){

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == value){
        return i;
      }
    }
    return -1;
  }


}
