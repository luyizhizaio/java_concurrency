package com.kyrie.datastructure.tree;

/**
 * Created by tend on 2020/10/10.
 * 二叉树
 */
public class BinaryTree<T> {

    //树根
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    /**
     * 先序遍历：先输出父节点，再遍历左子树和右子树
     */
    public void preOrder(){
        //preOrder(root);
        this.root.preOrder();
    }
    /**
     * 中序遍历
     */
    public void infixOrder(){
        //infixOrder(root);
        this.root.infixOrder();
    }

    public void postOrder(){
        this.root.postOrder();
    }

}

//节点
class Node<T>{
    private T value;

    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * 先序遍历
     */
    public void preOrder(){
        System.out.print(this.getValue() +" ");

        if(this.getLeft() !=null){
            this.getLeft().preOrder();
        }

        if(this.getRight() !=null){
            this.getRight().preOrder();
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder(){

        if(this.getLeft() !=null){
            this.getLeft().infixOrder();
        }

        System.out.print(this.getValue() +" ");

        if(this.getRight() !=null){
            this.getRight().infixOrder();
        }
    }


    /**
     * 后序遍历
     */
    public void postOrder(){

        if(this.getLeft() !=null){
            this.getLeft().postOrder();
        }

        if(this.getRight() !=null){
            this.getRight().postOrder();
        }

        System.out.print(this.getValue() +" ");
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}