package com.kyrie.datastructure.treeApplication;

import java.util.*;
/**
 * Created by tend on 2020/10/22.
 */
public class HuffmanTree {
    public static void main(String[] args) {

        int[] arr ={13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);

        System.out.println(huffmanTree);

        preOrder(huffmanTree);
    }

    private static void preOrder(Node huffmanTree) {
        huffmanTree.preOrder();
    }
    public static Node  createHuffmanTree(int[] arr){
        /**对于给定的有各自权值的 n 个结点，构建哈夫曼树有一个行之有效的办法：
         1.在 n 个权值中选出两个最小的权值，对应的两个结点组成一个新的二叉树，且新二叉树的根结点的权值为左右孩子权值的和；
         2.在原有的 n 个权值中删除那两个最小的权值，同时将新的权值加入到 n–2 个权值的行列中，以此类推；
         3.重复 1 和 2 ，直到所以的结点构建成了一棵二叉树为止，这棵树就是哈夫曼树。
         */

        //
        ArrayList<Node> nodes = new ArrayList(arr.length);
        for (int i : arr) {

            nodes.add(new Node(i));
        }

        while(nodes.size()>1){

            Collections.sort(nodes);
            Node first = nodes.remove(0);
            Node second = nodes.remove(0);
            int parentValue = first.weight + second.weight;
            Node parentNode = new Node(parentValue);

            parentNode.left = first;
            parentNode.right = second;
            nodes.add(parentNode);

        }

        return nodes.get(0);

    }
}


class Node implements Comparable<Node>{

    Byte data; //存放数据的ascll，

    int weight;

    Node left;

    Node right;

    public Node(){

    }

    public Node(int weight) {
        this.weight = weight;
    }

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    public void preOrder() {

        System.out.print(this.weight +" ");
        if(this.left !=null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}