package com.kyrie.datastructure.treeApplication;

import com.kyrie.datastructure.treeApplication.BalancedBinaryTree.Node;

/**
 * Created by tend on 2020/10/30.
 * 平衡二叉树;或AVL树
 */
public class BalancedBinaryTreeDemo {

    public static void main(String[] args) {


        int[] arr ={4,3,5,2,1,0};
        //int[] arr = {4,3,6,5,7,8};
        BalancedBinaryTree avlTree = new BalancedBinaryTree();
        for(int i:arr){
            Node node = new Node(i);
            avlTree.add(node);
        }
        //中序遍历
        avlTree.infixOrder();

    }
}


class BalancedBinaryTree{

    public Node root;


    public void add(Node node){
        if(root ==null){
            root = node;
        }else{
            root.add(node);
        }
    }


    public void infixOrder(){
        if(root !=null){
            root.infixOrder();
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void add(Node node){

            if(node == null){
                return;
            }

            if(this.value >node.value){
                if(this.left == null){
                    this.left = node;
                }else{
                    this.left.add(node);
                }
            }else{
                if(this.right == null){
                    this.right =node;
                }else{
                    this.right.add(node);
                }

            }
            //旋转：
            //添加左子树的左子树 右旋
            //添加右子树的右子树 左旋
            //添加左子树的右子树 左旋右旋
            //添加右子树的左子树 右旋左旋

            if(this.leftHeight() - this.rightHeight()>1){
                if(this.left!=null &&this.left.rightHeight() -this.rightHeight()>0){ //左子树的右子树
                    this.left.leftRotate();
                }
                this.rightRotate();

                return;
            }

            if(this.rightHeight()- this.leftHeight() >1){
                if(this.right!=null &&this.right.leftHeight() > this.leftHeight()){ //右子树的左子树
                    this.right.rightRotate();
                }
                this.leftRotate();
            }
        }

        //左旋
        public void leftRotate(){

            //1.创建新节点:
            // 新结点的值=当前结点的值（也就是4）；
            // 新结点的左节点=当前节点的左节点（3）
            // 新结点的右节点=当前结点的右结点的左节点（5）
            Node node = new Node(this.value);
            node.left = this.left;
            node.right = this.right.left;
            //2.修改当前节点
            //当前结点的值=当前节点的右节点
            //当前节点的右子树=当前节点的右子树的右子树
            //当前节点的左子树=新结点
            this.value = this.right.value;
            this.right = this.right.right;
            this.left = node;

        }

        //右旋
        public void rightRotate(){
            //1
            Node node = new Node(this.value);
            node.right = this.right;
            node.left = this.left.right;

            //2
            this.value = this.left.value;
            this.left = this.left.left;
            this.right = node;
        }


        public void infixOrder(){
            if(this.left !=null){
                this.left.infixOrder();
            }
            System.out.print(this.value+" ");

            if(this.right !=null){
                this.right.infixOrder();
            }

        }

        /**
         * 左子树高度
         * @return
         */
        public int leftHeight(){
            if(left ==null){
                return 0;
            }else{
                return left.height();
            }
        }

        /**
         * 右子树高度
         * @return
         */
        public int rightHeight(){
            if(right ==null){
                return 0;
            }else{
                return right.height();
            }
        }

        private int height(){
            return Math.max(this.left ==null ?0:this.left.height(),this.right == null ?0:this.right.height())+1;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
