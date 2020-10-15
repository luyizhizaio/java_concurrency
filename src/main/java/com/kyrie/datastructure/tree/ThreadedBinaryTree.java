package com.kyrie.datastructure.tree;

/**
 * Created by tend on 2020/10/15.
 */
public class ThreadedBinaryTree<T> {

    private ThreadedNode<T> root;
    private ThreadedNode<T> pre; //索引化前驱

    public ThreadedNode<T> getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode<T> root) {
        this.root = root;
    }

    /**
     * 线索化二叉树
     */
    public void threadedNodes(){

        if(this.root != null){
            this.threadedNodes(root);
        }
    }

    //8 3 10 1 14 6
    private void threadedNodes(ThreadedNode<T> root) {

        //左指向前驱
        ThreadedNode<T> left = root.getLeft();

        if(left !=null){
           threadedNodes(left);
        }else{
            root.setLeft(pre);
            root.setLtag(1);
        }

        System.out.print(root.getValue() +" ");

        if(pre !=null && pre.getRight() ==null){
            pre.setRight(root);
            pre.setRtag(1);
        }
        pre = root;


        //右指向后继
        ThreadedNode<T> right = root.getRight();
        if(right != null){
            threadedNodes(right);
        }
    }
}

//节点
class ThreadedNode<T>{
    private T value;

    private ThreadedNode<T> left;
    private ThreadedNode<T> right;

    private int ltag; // ltag为0时指向该结点的左孩子，为1时指向该结点的前驱
    private int rtag; // rtag为0时指向该结点的右孩子，为1时指向该结点的后继

    public ThreadedNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ThreadedNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode<T> left) {
        this.left = left;
    }

    public ThreadedNode<T> getRight() {
        return right;
    }

    public void setRight(ThreadedNode<T> right) {
        this.right = right;
    }

    public int getLtag() {
        return ltag;
    }

    public void setLtag(int ltag) {
        this.ltag = ltag;
    }

    public int getRtag() {
        return rtag;
    }

    public void setRtag(int rtag) {
        this.rtag = rtag;
    }
}
