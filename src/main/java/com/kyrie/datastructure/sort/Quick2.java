package com.kyrie.datastructure.sort;

/**
 * Created by Kyrie on 2020/1/14.
 */
public class Quick2 extends BaseSort{


    public static void sort(Comparable[] a){
        sort(a,0, a.length -1);
    }


    public static void sort(Comparable [] a, int lo ,int hi){

//        if(hi <=lo + M) {Insertion.sort(a,lo,hi);}
        int j = partition(a,lo,hi);
        sort(a,lo ,j-1);
        sort(a,j+1,hi);

    }



    public static int partition(Comparable [] a, int lo ,int hi){
        int i = lo;
        int j = hi +1;

        Comparable k = a[lo];

        while(true){

            while(less(a[++i],k)) if(i == hi) break;
            while(less(k,a[--j])) if(j == lo) break;
            if(i>=j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    public static void main(String[] args) {
        Comparable [] a = {"s","m","a","r","t"};
        sort(a);
        show(a);


    }

}
