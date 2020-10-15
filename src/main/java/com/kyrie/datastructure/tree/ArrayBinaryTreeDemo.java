package com.kyrie.datastructure.tree;

import org.junit.Test;

/**
 * Created by tend on 2020/10/14.
 * 顺序存储二叉树测试
 */
public class ArrayBinaryTreeDemo {

    @Test
    public void traverse(){

        int []arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        System.out.println("preOrder:");
        abt.preOrder(); //1 2 4 5 3 6 7

        System.out.println("\ninfixOrder:");
        abt.infixOrder();//4 2 5 1 6 3 7

        System.out.println("\npostOrder:");
        abt.postOrder(); //4 5 2 6 7 3 1
    }
}
