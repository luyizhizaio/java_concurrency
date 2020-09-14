package com.kyrie.datastructure.search.practice;

/**
 * 插值查找
 */
public class InsertValueSearch {

  public static void main(String[] args) {
    int[] arr ={2,2,2,3,4,5,26,47,58,69,110,123};
    int index = search(arr, 0 , arr.length-1,111);
    System.out.println(index);
  }


  public static int search(int[] arr, int  left ,int right, int value){

    if(left > right || value < arr[0] || value> arr[arr.length -1]){
      return -1;
    }
    //求出自适应mid
    int mid = left == right ? left : left + (right -left) *(value - arr[left])/(arr[right] - arr[left]);

    if(value > arr[mid]){
      return search(arr,mid +1,right,value);
    }else if(value < arr[mid]){
      return search(arr,left,mid -1, value);
    }else{
      return mid;
    }
  }


}
