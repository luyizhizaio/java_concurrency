package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2020/1/3.
 * 自顶向下的归并排序,利用分治思想
 */
public class Merge extends BaseSort {

    //辅助数组
    private static Comparable aux [];


    public static void main(String [] args){

        Integer [] a = {7,5,1,6,3};
        sort(a);
        show(a);

    }


    public static void sort(Comparable[] a){

        aux = new Comparable[a.length];

        sort(a ,0, a.length -1);


    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);//排序左半边
        sort(a,mid+1, hi);//排序右半边
        merge(a,lo,mid,hi); //归并
//        show(a);
    }


    /**
     * 合并两半有序的数组
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a,int lo,int mid ,int hi) {

        int i = lo ,j = mid +1;

        for(int k =lo; k<=hi;k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++){

            if (i> mid) a[k] = aux[j++]; // i大于左边数组最大下标，说明左边数组空了，把右边数组插入原来数组
            else if (j>hi) a[k] = aux[i++]; // j大于右边数组最大下标，说明右边数组空了，把左边数组插入原来数组
            else if (less(aux[j],aux[i])) a[k] =aux[j++]; //判断 右边小于左边 取右边的元素
            else a[k] = aux[i++]; //左边小于右边， 取左边


        }


    }



}
