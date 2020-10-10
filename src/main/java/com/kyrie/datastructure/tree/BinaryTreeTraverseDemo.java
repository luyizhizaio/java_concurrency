package com.kyrie.datastructure.tree;

/**
 * Created by tend on 2020/10/10.
 * 二叉树遍历demo
 */
public class BinaryTreeTraverseDemo {


    public static void main(String[] args) {

        BinaryTree<String> bt = new BinaryTree<>();

        Node<String> root = new Node<String>("LBJ");
        Node<String> node1 = new Node<String>("AD");
        Node<String> node2 = new Node<String>("KO");
        Node<String> node3 = new Node<String>("KD");
        Node<String> node4 = new Node<String>("SK");

        node1.setLeft(node3);
        node3.setRight(node4);

        root.setLeft(node1);
        root.setRight(node2);

        bt.setRoot(root);

        System.out.println("先序遍历：");
        bt.preOrder();

        System.out.println("\n中序遍历：");
        bt.infixOrder();

        System.out.println("\nh后序遍历：");
        bt.postOrder();

    }
}
