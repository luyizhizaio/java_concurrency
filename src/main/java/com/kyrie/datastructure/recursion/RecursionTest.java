package com.kyrie.datastructure.recursion;

/**
 * Created by tend on 2020/9/11.
 */
public class RecursionTest {

    public static void main(String[] args) {

        test(10);

    }

    public static void test(int a){
        if(a == 0) return;
        a--;
        test(a); //test2
        System.out.println(a);
    }

    public static void test2(int a){
        if(a == 0) return;
    }
}
