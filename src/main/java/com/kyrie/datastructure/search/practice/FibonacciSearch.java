package com.kyrie.datastructure.search.practice;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {

  public static void main(String[] args) {
    System.out.println(fibonacci(5));


    int[] arr ={2,2,2,3,4,5,26,47,58,69,110,123};
    int index = search(arr, 0 , arr.length-1,110);
    System.out.println(index);
  }



  public  static int fibonacci(int index){

    // 1 1 2 3 5 8 13 21 34 55

    if(index == 0 ||index == 1){
      return 1;
    }

    int first =1;
    int second = 1;
    int third = 0;
    for (int i = 1; i <index ; i++) {
      third = first + second;
      first = second;
      second = third;
    }

    return third;
  }


  public static int search(int[] arr, int left ,int right,int value){

    if(left > right){
      return -1;
    }
    //int mid = (left +right)/2;

    int n =right -left +1;
    int k = 0;

    while(n>fibonacci(k) -1){
      k++;
    }

    int mid = left +fibonacci(k -1) -1;

    if(value >arr[mid]){
      return search(arr,mid+1,right,value);
    }else if(value < arr[mid]){
      return search(arr, left,mid -1,value);
    }else {
      return mid;
    }


  }



}
