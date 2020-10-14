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

    /**
     * 后序遍历
     */
    public void postOrder(){
        this.root.postOrder();
    }

    /**
     * 先序查找
     */
    public Node<T> preOrderSearch(T value){

        return this.root.preOrderSearch(value);
    }

    /**
     * 中序查找
     */
    public Node<T> infixOrderSearch(T value){

        return this.root.infixOrderSearch(value);

    }


    public Node<T> postOrderSearch(T value) {

        return this.root.postOrderSearch(value);
    }

    public void deleteNode2(T value) {

        //TODO 未完成
        if(this.root !=null){
            if(this.root.getValue().equals(value)){
                Node<T> left = this.root.getLeft();
                Node<T> right = this.root.getRight();

                if(left !=null) {
                    this.setRoot(left);
                }
                else if(right !=null)this.setRoot(right);
                else this.setRoot(null);

            }else{
                this.root.deleteNode2(value);
            }
        }

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

        System.out.print(this.getValue() + " ");

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

        System.out.print(this.getValue() + " ");
    }


    /**
     * 先序查找
     * @param value
     * @return
     */
    public Node<T> preOrderSearch(T value) {

        if(this.value.equals(value)) {
            return this;
        }

        Node<T> resNode = null;
        if(this.getLeft() !=null){
            resNode = this.getLeft().preOrderSearch(value);
        }

        if(resNode !=null){
            return resNode;
        }

        if(this.getRight() !=null){
            resNode =  this.getRight().preOrderSearch(value);
        }


        return resNode;
    }



    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 中序遍历
     * @param value
     * @return
     */
    public Node<T> infixOrderSearch(T value) {
        Node<T> resNode =null;
        if(this.getLeft()!=null){
            resNode = this.getLeft().infixOrderSearch(value);
        }

        if(resNode !=null){
            return resNode;
        }

        if(this.value.equals(value)){
            return this;
        }

        if(this.getRight() !=null){
            resNode = this.getRight().infixOrderSearch(value);
        }
        return resNode;
    }

    /**
     * 后序遍历
     * @param value
     * @return
     */
    public Node<T> postOrderSearch(T value) {

        Node<T> resNode = null;

        if(this.getLeft()!=null){
            resNode = this.getLeft().postOrderSearch(value);
        }

        if(resNode !=null){
            return resNode;
        }

        if(this.getRight() != null){
            resNode = this.getRight().postOrderSearch(value);
        }

        if(this.value.equals(value)){
            return this;
        }

        return resNode;


    }

    public void deleteNode2(T value) {

        Node<T> left = this.getLeft();

        if(left != null){
            if(left.getValue().equals(value)){
                Node<T> subLeft = left.getLeft();
                Node<T> subRight = left.getRight();
                if(subLeft != null){
                    this.setLeft(subLeft);
                }else if(subRight != null){
                    this.setLeft(subRight);
                }else{
                    this.setLeft(null);
                }
            }else{
                left.deleteNode2(value);
            }
        }

        Node<T> right = this.getRight();
        if(right !=null){
            if(right.getValue().equals(value)){
                Node<T> subLeft = left.getLeft();
                Node<T> subRight = left.getRight();
                if(subLeft != null){
                    this.setLeft(subLeft);
                }else if(subRight != null){
                    this.setLeft(subRight);
                }else{
                    this.setLeft(null);
                }
            }else{
                right.deleteNode2(value);
            }
        }
    }
}