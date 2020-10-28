package com.kyrie.datastructure.treeApplication;

import com.kyrie.datastructure.treeApplication.BinarySortTree.Node;
/**
 * Created by tend on 2020/10/28.
 */
public class BinarySortTreeMain {


    public static void main(String[] args) {

        int[] arr = {7,3,10,12,5,1,9};

        BinarySortTree bst = new BinarySortTree();

        for(int i : arr){
            Node node = new Node(i);

            bst.add(node);
        }

        System.out.println("中序遍历：");
        bst.infixOrder();

        bst.add(new Node(2));

        System.out.println("\n中序遍历：");
        bst.infixOrder();


        //删除节点
        bst.delNode(1);


    }

}


