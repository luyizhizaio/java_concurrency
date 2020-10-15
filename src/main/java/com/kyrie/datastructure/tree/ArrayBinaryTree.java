package com.kyrie.datastructure.tree;

/**
 * Created by tend on 2020/10/14.
 * 顺序存储二叉树
 */
public class ArrayBinaryTree {

    private int[] arr ;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 先序遍历
     */
    public void preOrder(){
        preOrder(0);
    }

    private void preOrder(int rootIndex){

        int n = arr.length;

        System.out.print(arr[rootIndex] + " ");

        //left
        int leftIndex = 2 * rootIndex +1;
        if(leftIndex < n) {
            preOrder(leftIndex);
        }

        //right
        int rightIndex = 2 * rootIndex +2;
        if(rightIndex < n){
            preOrder(rightIndex);
        }

    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        infixOrder(0);
    }

    private void infixOrder(int rootIndex) {

        int n = arr.length;

        //left
        int leftIndex = 2 * rootIndex +1;
        if(leftIndex < n) {
            infixOrder(leftIndex);
        }

        System.out.print(arr[rootIndex] + " ");

        //right
        int rightIndex = 2 * rootIndex +2;
        if(rightIndex < n){
            infixOrder(rightIndex);
        }
    }

    public void postOrder() {

        postOrder(0);
    }

    private void postOrder(int rootIndex) {

        int n = arr.length;

        //left
        int leftIndex = 2 * rootIndex +1;
        if(leftIndex < n) {
            postOrder(leftIndex);
        }

        //right
        int rightIndex = 2 * rootIndex +2;
        if(rightIndex < n){
            postOrder(rightIndex);
        }

        System.out.print(arr[rootIndex] + " ");
    }
}
