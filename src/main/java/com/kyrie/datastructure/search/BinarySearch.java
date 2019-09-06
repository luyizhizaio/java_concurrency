package com.kyrie.datastructure.search;

/**
 * Created by tend on 2017/6/15.
 * 二分查找：
 *
 */
public class BinarySearch {


    public  static void main(String[]args){

        int[] data = {1,5,6,13,14,15,17,30};
        int target =17;
        int index = binarySearch2(data,0,data.length-1,target);
        if(index >-1){
            System.out.println("found:"+index);
        }else{
            System.out.println("not found");
        }

    }

    private static int binarySearch1(int[] data,int from ,int to ,int target){

        if(from <=to){

            int mid = from + (to -from)/2;
            if(data[mid] < target){
                return binarySearch1(data, mid + 1, to, target);
            } else if (data[mid] > target){
                return binarySearch1(data, from, mid - 1, target);
            }else{
                return mid;
            }

        }
        return -1;
    }


    private static int binarySearch2(int[] data,int from ,int to , int target){
        while(from <= to){
            int mid =from +(to-from)/2;
            if(data[mid] <target){
                from =mid +1;
            }else if (data[mid]> target){
                to = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
