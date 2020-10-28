package com.kyrie.datastructure.treeApplication;

/**
 * Created by tend on 2020/10/28.
 */
public class BinarySortTree {

    public Node root;


    public void add(Node node){

        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }

    public void infixOrder(){
        if(root!=null){
            root.infixOrder();
        }
    }

    /**
     * 删除节点
     * @param value
     */
    public void delNode(int value) {

        //先是找到该节点-删除该节点

    }

    static class Node{


        int value;

        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
         * 增加节点
         * @param node
         */
        public void add(Node node){

            if(this.value < node.value){ //大于当前节点往右放
                if(this.right == null){
                    this.right = node;
                }else{
                    this.right.add(node);
                }
            }else{ //小于等于当前节点往左放
                if(this.left == null){
                    this.left = node;
                }else{
                    this.left.add(node);
                }
            }

        }

        public void infixOrder(){

            if(this.left!=null){
                this.left.infixOrder();
            }
            System.out.print(this.value + " ");

            if(this.right!=null){
                this.right.infixOrder();
            }
        }


    }

}


