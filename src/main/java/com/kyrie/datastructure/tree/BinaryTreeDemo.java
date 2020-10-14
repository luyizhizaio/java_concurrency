package com.kyrie.datastructure.tree;

import org.junit.Test;

/**
 * Created by tend on 2020/10/10.
 * 二叉树案例
 */
public class BinaryTreeDemo {
    /**
     * 二叉树遍历demo
     */
    @Test
    public void traverseBT() {

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


    /**
     * 二叉树-查找
     * 前序，中序，后序查找
     */
    @Test
    public void searchBT(){

        BinaryTree<String> bt = new BinaryTree<>();

        Node<String> root = new Node<String>("宋江");
        Node<String> node1 = new Node<String>("吴用");
        Node<String> node2 = new Node<String>("卢俊");
        Node<String> node3 = new Node<String>("关胜");
        Node<String> node4 = new Node<String>("林冲");

        node2.setLeft(node3);
        node2.setRight(node4);

        root.setLeft(node1);
        root.setRight(node2);

        bt.setRoot(root);

        Node<String> searchNode1 = bt.preOrderSearch("关胜");
        System.out.println(searchNode1);

        Node<String> searchNode2 = bt.infixOrderSearch("关胜");
        System.out.println(searchNode2);

        Node<String> searchNode3 = bt.postOrderSearch("关胜");
        System.out.println(searchNode3);

    }

    /**
     * 删除节点：
     l ）如果要删除的节点是非叶子节点，现在我们不希望将该非叶子节点为根节点的子树删除，需要指定规则，假如规定如下：
     2 ）如果该非叶子节点 A 只有一个子节点 B ，则子节点 B 替代节点 A
     3 ）如果该非叶子节点 A 有左子节点 B 和右子节点 C ，则让左子节点 B 替代节点 A 。
     4 ）请大家思考，如何完成该删除功能，老师给出提示．（课后练习）
     5 ）后面在讲解几叉排序树时，在给大家讲解具体的删除方法
     */
    @Test
    public void deleteNode2(){

        BinaryTree<String> bt = new BinaryTree<>();

        Node<String> root = new Node<String>("宋江");
        Node<String> node1 = new Node<String>("吴用");
        Node<String> node2 = new Node<String>("卢俊");
        Node<String> node3 = new Node<String>("关胜");
        Node<String> node4 = new Node<String>("林冲");

        node2.setLeft(node3);
        node2.setRight(node4);

        root.setLeft(node1);
        root.setRight(node2);

        bt.setRoot(root);

        bt.preOrder();
        System.out.println();
        bt.deleteNode2("宋江");
        bt.preOrder();

    }

}
