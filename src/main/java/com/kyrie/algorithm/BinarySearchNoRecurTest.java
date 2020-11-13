package com.kyrie.algorithm;

/**
 * 1.二分查找非递归模式
 */
public class BinarySearchNoRecurTest {

    public static void main(String[] args) {

        int[] arr = {1,4,5,6,7,8,9};
        Integer index = binarySearch(arr,10);
        System.out.println("index:"+index);
    }



    public static Integer binarySearch(int[] arr, int value){


        int start = 0, end = arr.length -1;
        int index = 0;

        Integer result = null;

        while(start <= end){
            index = (end + start)/2;
            int cv = arr[index];
            if(value >cv){ //大于中间值
                start = index+1;
            }else if(value < cv){
                end = index-1;
            }else{
                result = index;
                break;
            }
        }
        return result;
    }

}




