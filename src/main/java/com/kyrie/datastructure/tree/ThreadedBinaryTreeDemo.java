package com.kyrie.datastructure.tree;

import org.junit.Test;

/**
 * Created by tend on 2020/10/15.
 * 线索化二叉树案例
 */
public class ThreadedBinaryTreeDemo {


    /**
     * 中序线索化二叉树
     */
    @Test
    public void infixOrderThreadedNode(){

        ThreadedNode<Integer> root = new ThreadedNode<Integer>(1);
        ThreadedNode<Integer> node1 = new ThreadedNode<Integer>(3);
        ThreadedNode<Integer> node2 = new ThreadedNode<Integer>(6);
        ThreadedNode<Integer> node3 = new ThreadedNode<Integer>(8);
        ThreadedNode<Integer> node4 = new ThreadedNode<Integer>(10);
        ThreadedNode<Integer> node5 = new ThreadedNode<Integer>(14);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);


        ThreadedBinaryTree<Integer> tbt = new ThreadedBinaryTree<>();
        tbt.setRoot(root);

        tbt.infixOrderthreadedNodes();


        System.out.println("索引化二叉树验证：");
        //8
        System.out.println(""+node3.getRight());

        //10
        System.out.println(node4.getLeft());
        System.out.println(node4.getRight());

        //14
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


    }

    /**
     * 遍历中序线索化二叉树
     */
    @Test
    public void traverse(){


        ThreadedNode<Integer> root = new ThreadedNode<Integer>(1);
        ThreadedNode<Integer> node1 = new ThreadedNode<Integer>(3);
        ThreadedNode<Integer> node2 = new ThreadedNode<Integer>(6);
        ThreadedNode<Integer> node3 = new ThreadedNode<Integer>(8);
        ThreadedNode<Integer> node4 = new ThreadedNode<Integer>(10);
        ThreadedNode<Integer> node5 = new ThreadedNode<Integer>(14);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);


        ThreadedBinaryTree<Integer> tbt = new ThreadedBinaryTree<>();
        tbt.setRoot(root);

        tbt.infixOrderthreadedNodes();


        System.out.println("\n 中序遍历：");
        tbt.infixOrder();
    }



    /**
     * 先序线索化二叉树
     */
    @Test
    public void preOrderThreadedNode(){

        ThreadedNode<Integer> root = new ThreadedNode<Integer>(1);
        ThreadedNode<Integer> node1 = new ThreadedNode<Integer>(3);
        ThreadedNode<Integer> node2 = new ThreadedNode<Integer>(6);
        ThreadedNode<Integer> node3 = new ThreadedNode<Integer>(8);
        ThreadedNode<Integer> node4 = new ThreadedNode<Integer>(10);
        ThreadedNode<Integer> node5 = new ThreadedNode<Integer>(14);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);


        ThreadedBinaryTree<Integer> tbt = new ThreadedBinaryTree<>();
        tbt.setRoot(root);

        tbt.preOrderthreadedNodes();


        System.out.println("索引化二叉树验证：");
        //8
        System.out.println(""+node3.getRight());

        //10
        System.out.println(node4.getLeft());
        System.out.println(node4.getRight());

        //6
        System.out.println(node2.getLeft());
        System.out.println(node2.getRight());

        //14
        System.out.println(node5.getLeft());
        System.out.println(node5.getRight());


    }


}
