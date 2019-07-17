package com.kyrie.datastructure.sort.practice;

/**
 * Created by tend on 2019/7/10.
 * 分治：找到中间的值，把数据分为两部分
 */
public class QuickSort1 {


    public static void main(String[] args) {

        int[] arr = {4,1,5,6,23,1,34,56,3,7,3,4,7,8,3,2,4,6,7,89,97,6,44,22,454,776,4,3,2,12};
        sort(arr,0,arr.length -1);

//        quick_sort(arr,0,arr.length -1);

    }



    public static void sort(int[] arr,int low,int high){
        print(arr);
        if(low < high){
            int mid = getMiddleNumber(arr,low,high);
            sort(arr,low,mid -1);
            sort(arr,mid +1,high);
        }

    }

    public static int getMiddleNumber(int[] arr,int low, int high) {

        int k = arr[low];
        while(low < high){

            while(low < high && arr[high] >= k){
                high--;
            }
            arr[low] = arr[high]; //找出high比low小的数
            while(low < high && arr[low] < k){ //比第一位打
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = k;
        return low;
    }

    public static void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


    //快速排序
    static void quick_sort(int s[], int l, int r)
    {
        print(s);
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }



}
