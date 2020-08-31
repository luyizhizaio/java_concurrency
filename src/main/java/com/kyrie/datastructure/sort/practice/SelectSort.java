package com.kyrie.datastructure.sort.practice;

public class SelectSort {

  public static void main(String[] args) {

    int a[] =new int[]{23,46,0,8,11,18};

    sort(a);

    print(a);


  }

  public static void sort(int[] arr){

    for (int i = 0; i < arr.length-1 ; i++) {

      int min = arr[i];
      int index = i; //最小值的index
      for (int j = i ; j < arr.length; j++) {
          if(arr[j] < min ){
            min = arr[j];
            index=j;
          }
      }
      if(index !=i){
        int tmp = arr[i];
        arr[i] = min;
        arr[index] = tmp;
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
