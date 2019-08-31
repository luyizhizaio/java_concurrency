package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2019/8/31.
 */
public class BaseSort {
    /**
     * 比较
     * @param v
     * @param w
     * @return
     */
    protected static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <0;
    }

    /**
     * i与j交换
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] a,int i ,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j] = t;
    }

    /**
     * 输出
     * @param a
     */
    protected static void show(Comparable[] a){
        for(int i = 0; i< a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a){
        for(int i =1 ; i < a.length;i++){
            if (less(a[i],a[i-1])) return false;
        }
        return true;

    }


}
