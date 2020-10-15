package com.kyrie.datastructure.tree;

/**
 * Created by tend on 2020/10/15.
 */
public class ThreadedBinaryTree<T> {


    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
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

    private void threadedNodes(Node<T> root) {



    }


}
