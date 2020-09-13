package com.kyrie.datastructure.sort.practice;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {

  public static void main(String[] args) {




    int arr[] = new int[]{5, 4, 7, 9, 3, 8, 2, 1,6};
    sort2(arr);
    print(arr);


    int[] arr2 = new int[10000000];

    for (int i = 0; i <arr2.length ; i++) {
      arr[i] = (int)(Math.random() *10000000);
    }

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    simpleDateFormat.format(date);


  }

  /**
   * 移位式
   * @param arr
   */
  public static void sort(int[] arr) {
    for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {//gap逐渐缩小

      for (int i = gap; i < arr.length; i += gap) {

        int index = i - gap;// 有序数组上界

        int value = arr[i];

        while (index >= 0 && value < arr[index]) {
          arr[index + gap] = arr[index];
          index -= gap;
        }
        arr[index + gap] = value;
      }
    }

  }


  /**
   * 交换式
   * @param arr
   */
  public static void sort2(int[] arr) {
    for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {//gap逐渐缩小

      for (int i = gap; i < arr.length; i += gap) {

        int index = i - gap;// 有序数组上界

        int value = arr[i];

        while (index >= 0 && value < arr[index]) {
          int tmp= arr[index];
          arr[index] = value;
          arr[index+gap] = tmp;
          index -= gap;
        }
      }
    }
  }


  public static void print(int a[]) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

}
