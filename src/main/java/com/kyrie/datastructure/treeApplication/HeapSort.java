package com.kyrie.datastructure.treeApplication;

import java.util.Arrays;

/**
 * Created by tend on 2020/10/20.
 * 堆排序
 */
public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {4,6,8,5,9};

        heapSort(arr);

        System.out.println(Arrays.toString(arr));


    }

    public static void heapSort(int[] arr){


        //1.构建大顶堆 ;将无序序列构造成大顶堆,升序采用大顶堆，降序采用小顶堆
        for(int i = arr.length/2 -1 ;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素 9 6 8 5 4
        for(int j = arr.length -1;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }




    }

    /**
     * 完成将以i对应的非叶子节点的树调整为大顶堆
     * @param array
     * @param parent
     * @param length 表示对多少个元素继续调整，length会逐渐变小
     */
    public static void adjustHeap(int[] array, int parent, int length) {
        int temp = array[parent]; // temp保存当前父节点
        int child = 2 * parent + 1; // 先获得左孩子

        while (child < length) {
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= array[child]){
                break;
            }

            // 把孩子结点的值赋给父结点
            array[parent] = array[child];

            // 选取孩子结点的左孩子结点,继续向下筛选
            parent = child;
            child = 2 * child + 1;
        }

        array[parent] = temp;
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
