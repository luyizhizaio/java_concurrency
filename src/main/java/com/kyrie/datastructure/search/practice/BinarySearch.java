package com.kyrie.datastructure.search.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {


  public static void main(String[] args) {
    int[] arr ={2,2,2,3,4,5,26,47,58,69,110,123};
    int index = search(arr, 0 , arr.length-1,111);
    System.out.println(index);

    List<Integer> indexs = search2(arr, 0 , arr.length-1,2);
    indexs.forEach(x -> System.out.println(x));
  }

  /**
   * 递归
   * @param arr
   * @param left
   * @param right
   * @param value
   * @return
   */
  public static int search(int arr[],int left,int right ,int value){

    if(left > right){
      return -1;
    }
    int mid = (left +right)/2;

    if(value >arr[mid]){
      return search(arr,mid+1,right,value);
    }else if(value < arr[mid]){
      return search(arr, left,mid -1,value);
    }else {
      return mid;
    }
  }

  /**
   * 返回多个下标
   * @param arr
   * @param left
   * @param right
   * @param value
   * @return
   */
  public static ArrayList search2(int arr[],int left,int right ,int value){

    if(left > right){
      return new ArrayList<Integer>();
    }
    int mid = (left +right)/2;

    if(value >arr[mid]){
      return search2(arr,mid+1,right,value);
    }else if(value < arr[mid]){
      return search2(arr, left,mid -1,value);
    }else {
      ArrayList<Integer> list = new ArrayList<>();
      for (int i = mid-1; i >=left ; i--) {
        if(arr[i] == value) list.add(i);
      }
      list.add(mid);
      for (int i = mid+1; i <=right ; i++) {
        if(arr[i] == value) list.add(i);
      }
      return list;
    }
  }
}
