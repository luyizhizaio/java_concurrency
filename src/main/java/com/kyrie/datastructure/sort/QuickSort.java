package com.kyrie.datastructure.sort;

/**
 * Created by tend on 2017/6/15.
 * 快排：挖坑分治法 ：https://blog.csdn.net/morewindows/article/details/6684558
 */
public class QuickSort {

    public  static void main(String[]args){

        int[] a = {4,1,5,6,23,1,34,56,3,7,3,4,7,8,3,2,4,6,7,89,97,6,44,22,454,776,4,3,2,12};
        //int a[] = {3,7,5,4,2,20,1,34,1,-1};
        QuickSort qs = new QuickSort();
        System.out.print("初始值：");
        qs.print(a);
        qs.quickSort(a,0,a.length-1);
        System.out.print("排序后：");
        qs.print(a);


    }

    private void quickSort(int[] a ,int low,int high){

        if(low < high){
            print(a);
            System.out.println("low:"+low +",high:"+high);
            int middle =getMiddle(a, low ,high);
            System.out.println("middle:"+middle);
            quickSort(a,low,middle-1);
            quickSort(a, middle + 1, high);
        }
    }

    public int getMiddle(int[] a , int low, int high){

        int key = a[low];
        while (low < high){
            while(low <high && a[high] >=key){//从右向左找 小于key的数
                high --;
            }
            if(low <high) a[low++] =a[high];
            while (low < high && a[low] < key){ //从左向右找 大于key的数
                low ++;
            }
            if(low <high) a[high--] = a[low];
        }
        a[low] =key;
        return low;

    }
    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
