package com.kyrie.datastructure.sort.practice;

public class BubbleSort {

  public static void main(String[] args) {

    int a[] =new int[]{4,2,6,5,3,1};

    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.sort(a);

    bubbleSort.print(a);

  }

  public void sort(int[] arr){

    for (int i = 0; i <arr.length ; i++) {

      for (int j = 0; j < arr.length -i-1 ; j++) {

        if(arr[j] > arr[j+1]){
          int tmp = 0;
          tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }
  }


  public void print(int a[]){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }
}
