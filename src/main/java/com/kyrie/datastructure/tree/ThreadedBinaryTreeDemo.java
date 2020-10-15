package com.kyrie.datastructure.tree;

import org.junit.Test;

/**
 * Created by tend on 2020/10/15.
 * 索引化二叉树案例
 */
public class ThreadedBinaryTreeDemo {

    @Test
    public void threadedNode(){

        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(3);
        Node<Integer> node2 = new Node<Integer>(6);
        Node<Integer> node3 = new Node<Integer>(8);
        Node<Integer> node4 = new Node<Integer>(10);
        Node<Integer> node5 = new Node<Integer>(14);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);


        ThreadedBinaryTree<Integer> tbt = new ThreadedBinaryTree<>();
        tbt.setRoot(root);

        tbt.threadedNodes();

    }
}
