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
     * 中序线索化二叉树
     */
    public void infixOrderthreadedNodes(){

        if(this.root != null){
            this.infixOrderthreadedNodes(root);
        }
    }

    //8 3 10 1 14 6
    private void infixOrderthreadedNodes(ThreadedNode<T> root) {

        //左指向前驱
        ThreadedNode<T> left = root.getLeft();

        if(left !=null){
           infixOrderthreadedNodes(left);
        }

        System.out.print(root.getValue() +" ");

        if(left ==null){
            root.setLeft(pre);
            root.setLtag(1);
        }

        if(pre !=null && pre.getRight() ==null){
            pre.setRight(root);
            pre.setRtag(1);
        }
        pre = root;


        //右指向后继
        ThreadedNode<T> right = root.getRight();
        if(right != null){
            infixOrderthreadedNodes(right);
        }
    }

    /**
     * 遍历中序线索化二叉树
     */
    public void infixOrder() {

        if(this.getRoot() !=null){
            this.root.infixOrder(root);
        }

    }

    /**
     * 先序索引化
     */
    public void preOrderthreadedNodes() {
        this.preOrderthreadedNodes(root);
    }

    private void preOrderthreadedNodes(ThreadedNode<T> root) {

        if(root !=null){
            System.out.print(root.getValue() + " ");
            //左子树为空，设置为前驱
            if(root.getLeft() == null){
                root.setLeft(pre);
                root.setLtag(1);
            }
            //前驱的右子树为空，设置当前节点为后继。
            if(pre !=null && pre.getRight()== null){
                pre.setRight(root);
                pre.setRtag(1);
            }

            pre = root;

            ThreadedNode<T> left = root.getLeft();
            if(root.getLtag() == 0){
                preOrderthreadedNodes(left);
            }

            ThreadedNode<T> right = root.getRight();
            if(root.getRtag() == 0){
                preOrderthreadedNodes(right);
            }

        }

    }

    /**
     * 先序遍历
     */
    public void preOrder() {

        this.root.preOrder(root);


    }

    /**
     * 后序线索化
     */
    public void postOrderThreadedNode() {

        this.postOrderThreadedNode(root);

    }

    private void postOrderThreadedNode(ThreadedNode<T> root) {


        if(root !=null){

            ThreadedNode<T> left = root.getLeft();
            if(left!=null){
                left.setParent(root);
                postOrderThreadedNode(left);
            }

            ThreadedNode<T> right = root.getRight();
            if(right!=null){
                right.setParent(root);
                postOrderThreadedNode(right);
            }

            System.out.print(root.getValue() +" ");
            if(root.getLeft() == null){
                root.setLeft(pre);
                root.setLtag(1);
            }

            if(pre !=null && pre.getRight() ==null){
                pre.setRight(root);
                pre.setRtag(1);
            }

            pre = root;
        }




    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        this.root.postOrder(root);

    }
}

//节点
class ThreadedNode<T>{
    private T value;

    private ThreadedNode<T> left;
    private ThreadedNode<T> right;

    private int ltag; // ltag为0时指向该结点的左孩子，为1时指向该结点的前驱
    private int rtag; // rtag为0时指向该结点的右孩子，为1时指向该结点的后继

    //双亲节点,后序线索二叉树需要用到
    public ThreadedNode<T> parent = null;

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

    public ThreadedNode<T> getParent() {
        return parent;
    }

    public void setParent(ThreadedNode<T> parent) {
        this.parent = parent;
    }

    public void infixOrder(ThreadedNode<T> root) {

        // ltag =0  left-> 左子树 ； ltag=1  left-> 前驱
        // rtag = 0 right -> 右子树； rtag=1 right->后驱

        //定义变量存储当前遍历的节点，从root开始
        ThreadedNode<T> node=root;

        while(node !=null){

            //循环找到ltag==1节点，为按照索引化处理后的有效节点
            while(node.getLtag() == 0){
                node = node.getLeft();
            }
            //输出
            System.out.print(node.getValue() + " ");

            //当前节点的右指针指向后继节点，一直输出
            while(node.getRtag() ==1){
                node = node.getRight();
                System.out.print(node.getValue() + " ");
            }

            //替换当前遍历的节点
            node =node.getRight();
        }

    }


    @Override
    public String toString() {
        return "ThreadedNode{" +
                "value=" + value +
                ", rtag=" + rtag +
                ", ltag=" + ltag +
                '}';
    }


    /**
     * 先序遍历
     */
    public void preOrder(ThreadedNode<T> root) {

        ThreadedNode<T> node =root;
        while(node !=null){
            System.out.print(node.getValue() +" ");
            if(node.getLtag() == 0){
                node = node.getLeft();
            }else{
                node = node.getRight();
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(ThreadedNode<T> root) {
        ThreadedNode<T> node = root;
        ThreadedNode<T> pre = null;
        while (node != null) {
            while(node.getLtag()==0){
                node = node.getLeft();
            }
            System.out.print(node.getValue() +" ");

            while(node.getRtag() == 1){
                pre = node;
                node = node.getRight();
                System.out.print(node.getValue() +" ");
            }

            //如果p没有后继,判断他是不是根节点,若是根,访问根,并且退出遍历.根据后续遍历的原则我们得知,
            //根节点就是最后一个节点
            if(node == root){
                System.out.print(node.getValue() + " ");
                break;
            }

            //若p不是根,且p不为null的情况下,如果p.rightNode == pre的话,
            // 代表着以当前节点p的左子树及其相关后继已经遍历完毕,
            //返回至p的双亲节点

            while(node !=null && node.getRight() == pre){
                System.out.print(node.getValue() + " ");
                pre = node;
                node = node.parent;
            }

            //如果p有右子树,遍历其右子树
            if(node !=null && node.getRtag() == 0){
                node = node.getRight();
            }
        }

    }
}
