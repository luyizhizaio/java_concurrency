package com.kyrie.datastructure.struct;

/**
 * Created by Kyrie on 2017/7/18.
 * 线性表（数组），声明、创建、赋值、遍历
 * 增加元素，需要将index后面的依次向后移动，然后将值插入index位置，删除则将后面的值依次向前移动
 */
public class Array {

    public static void main(String[]args){

        int value[] = new int[10];
        for(int i =0; i < 10; i++){
            value[i] = i;
        }

        traverse(value);

        //下标为3的位置插入一个元素
        int[] newValue = insert(value,8,3);

        traverse(newValue);

        //删除
        int[] newValue2 = delete(value,3);
        traverse(newValue2);
        //查找
        int index = findElem(value,3);
        System.out.println("index=" + index);
    }

    /**
     * 查找
     * @param arr
     * @param e
     * @return
     */
    public static int findElem(int[] arr,int e){

        int i ;
        for(i =0; i< arr.length;i++){
            if(e == arr[i]){
                return i;
            }
        }
        return -1;

    }


    /**
     * 指定位置插入元素
     * @param old
     * @param value
     * @param index
     * @return
     */
    public static int[] insert(int[] old , int value,int index){

        //
        for(int k = old.length-1; k>index; k--) {

            old[k] = old[k - 1];
        }
            old[index] = value;
            return old;

    }

    public static int[] delete(int[] old , int index){
        for(int h =index; h<old.length -1 ;h++){
            old[h] = old[h+1];
        }
        old[old.length -1] = 0;
        return old;
    }


    /**
     * 打印元素
     * @param data
     */
    public static void traverse(int data[]){
        System.out.println(" ");
        for (int i =0; i < data.length; i++)
            System.out.print(data[i] +" ");

    }


}
