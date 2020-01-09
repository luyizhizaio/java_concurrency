package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2020/1/9.
 * 自底向上的归并排序
 */
public class MergeBU extends BaseSort {

    private static Comparable [] aux;


    public static void main(String[] args) {
        Integer [] a = {7,5,1,6,3};
        sort(a);
        show(a);
    }

    /**
     * 排序算法
     */
    public static void sort(Comparable[] a){

        int N = a.length;

            aux = new Comparable[N];

        for(int sz = 1 ; sz < N; sz = sz +sz){

            for (int lo = 0; lo < N - sz ; lo += sz +sz ) {
                int mid = lo + sz -1;
                int hi = Math.min(lo + sz +sz -1 ,N -1);

                    System.out.println("merge(a,"+lo+","+mid+","+hi+")");
                merge(a ,lo , mid, hi);
                    show(a);
            }
        }
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

            if (i> mid) a[k] = aux[j++];
            else if (j>hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] =aux[j++];
            else a[k] = aux[i++];
        }

    }

}
