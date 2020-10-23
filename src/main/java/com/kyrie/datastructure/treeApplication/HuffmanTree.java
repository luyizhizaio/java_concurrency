package com.kyrie.datastructure.treeApplication;

import java.util.Comparator;

/**
 * Created by tend on 2020/10/22.
 */
public class HuffmanTree {

    public static void main(String[] args) {




    }


    public void  createHuffmanTree(int[] arr){
        //对于给定的有各自权值的 n 个结点，构建哈夫曼树有一个行之有效的办法：
//        在 n 个权值中选出两个最小的权值，对应的两个结点组成一个新的二叉树，且新二叉树的根结点的权值为左右孩子权值的和；
//        在原有的 n 个权值中删除那两个最小的权值，同时将新的权值加入到 n–2 个权值的行列中，以此类推；
//        重复 1 和 2 ，直到所以的结点构建成了一棵二叉树为止，这棵树就是哈夫曼树。

    }


}


class Node implements Comparator<Node>{

    private int value;

    private Node left;

    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compare(Node n1, Node n2) {
        return n1.getValue() - n2.getValue();
    }
}