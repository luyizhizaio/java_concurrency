package com.kyrie.datastructure.sort.practice;

/**
 * 基数排序
 */
public class RadixSort {

  public static void main(String[] args) {

    int a[] =new int[]{23,46,222333221,8,11,18};
    sort(a);

    print(a);

  }

  public static void sort(int[] arr){
    //找出最大值
    int max = arr[0];
    for (int i = 1; i <arr.length ; i++) {
      if(arr[i]>max) max = arr[i];
    }
    //获取最大长度
    int maxlength = (max+"").length();

    //逐位判断
    int mo = 1; //拥有取莫的数字
    for (int i = 0; i <maxlength  ; i++) {

      //创建桶
      int buckets[][] = new int[10][arr.length];
      for (int x = 0; x <10 ; x++) {
        buckets[x] = new int[arr.length];
      }
      //记录每个桶存数据的下标
      int indeies [] = new int[10];

      for (int j = 0; j < arr.length; j++) {
        int bucketNum = arr[j] / mo % 10; //重点，获取桶下标
        buckets[bucketNum][indeies[bucketNum]] = arr[j];
        indeies[bucketNum] += 1;
      }

      //拷贝到原数组
      int newindex =0;
      for (int k = 0; k <10 ; k++) {

        for (int j = 0; j <buckets[k].length ; j++) {
          if(buckets[k][j] != 0){
            arr[newindex++] = buckets[k][j];
          }
        }
      }
      mo *= 10;
    }
  }

  public static void print(int a[]){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i]+" ");
    }
    System.out.println();
  }

}
