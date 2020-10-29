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
        bst.delNode(7); //1 2 5 12
        System.out.println("\n中序遍历：");
        bst.infixOrder();
        bst.delNode(3);
        System.out.println("\n中序遍历：");
        bst.infixOrder();
        bst.delNode(9);
        System.out.println("\n中序遍历：");
        bst.infixOrder();
        bst.delNode(10);
        System.out.println("\n中序遍历：");
        bst.infixOrder();

    }

}
class BinarySortTree {

    public Node root;


    public void add(Node node) {

        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    /**
     * 删除节点
     *
     * @param value
     */
    public void delNode(int value) {

        //先是找到该节点-删除该节点

        Node node = search(value);

        if (node == null) {
            return;
        }

        //查找父节点
        Node parentNode = searchParent(value);

        if (parentNode == null) {//删除根节点
            if(root.left == null && root.right == null){
                root =null;
                return;
            }else if(root.left != null && root.right == null){
                root = root.left;
            }else if(root.right != null && root.left == null){
                root = root.right;
            }else{
                int minValue = delRightMinNode(root.right); //删除右子树最小的节点

                root.value = minValue;//右子树最小节点付给当前删除节点
            }
        }else{
            //情况1：删除节点没有左右子节点
            if (node.left == null && node.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else {
                    parentNode.right = null;
                }
            } else if (node.left != null && node.right == null) {//情况2：左子树存在，右子树不存在
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = node.left;
                } else {
                    parentNode.right = node.left;
                }
            } else if (node.left == null && node.right != null) { //情况3：右子树存在，左子树不存在
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = node.right;
                } else {
                    parentNode.right = node.right;
                }
            } else { //两个子节点都不为空
                int minValue = delRightMinNode(node.right); //删除右子树最小的节点
                node.value = minValue;//右子树最小节点付给当前删除节点
            }
        }
    }

    /**
     * 删除右子树最小的节点
     */
    public int delRightMinNode(Node node) {
        Node target = node;
        while (target.left != null) {
            target = node.left;
        }
        delNode(target.value);
        return target.value;
    }

    /**
     * 获取最小值
     *
     * @param node
     * @return
     */
    public Node searchMin(Node node) {

        if (node.left != null) {
            return searchMin(node.left);
        } else {
            return node;
        }
    }

    /**
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            if (root.value == value) {
                return null;
            } else {
                return this.root.searchParent(value);
            }
        }
    }

    /**
     * 搜索当前节点
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return this.root.search(value);
        }


    }


    static class Node {


        int value;

        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        /**
         * 增加节点
         *
         * @param node
         */
        public void add(Node node) {

            if (this.value < node.value) { //大于当前节点往右放
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.add(node);
                }
            } else { //小于等于当前节点往左放
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            }

        }

        /**
         * 中序遍历
         */
        public void infixOrder() {

            if (this.left != null) {
                this.left.infixOrder();
            }
            System.out.print(this.value + " ");

            if (this.right != null) {
                this.right.infixOrder();
            }
        }


        /**
         * 搜索当前节点
         *
         * @param value
         * @return
         */
        public Node search(int value) {

            if (this.value == value) {
                return this;
            }
            Node node = null;
            if (this.left != null) {
                node = this.left.search(value);
            }

            if (node != null) {
                return node;
            }

            if (this.right != null) {
                node = this.right.search(value);
            }
            return node;
        }


        /**
         * 搜索父节点
         *
         * @param value
         * @return
         */
        public Node searchParent(int value) {

            Node pNode = null;
            if (this.left != null) {
                if (this.left.value == value) {
                    return this;
                } else {
                    pNode = this.left.searchParent(value);
                }
            }
            if (pNode != null) {
                return pNode;
            }

            if (this.right != null) {
                if (this.right.value == value) {
                    return this;
                } else {
                    pNode = this.right.searchParent(value);
                }
            }
            return pNode;

        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

    }

}

