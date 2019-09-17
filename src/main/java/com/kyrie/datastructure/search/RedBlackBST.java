package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/11.
 * 红黑树:有序性和完美平衡性
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private Node root;

    private class Node{
        Key key;
        Value val;
        Node left,right;
        int N; //子树中的节点子树
        boolean color; //父节点指向其连接的颜色

        Node(Key key,Value val,int N,boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x ==null)return false;
        return x.color == RED;
    }

    /**
     * 左旋转，返回值为父节点指向的新的节点
     * @param h
     * @return
     */
    public Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 +size(h.left) + size(h.right);
        return x;

    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    public Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right= h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    /**
     * 颜色转化：
     * @param h
     */
    public void flipColors(Node h){
        h.color =RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }




    private int size(Node x) {
        if(x ==null)return 0;
        else return x.N;
    }

    /**
     * 插入节点
     * @param key
     * @param val
     */
    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if(h == null){
            return new Node(key,val,1,RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0 )h.left = put(h.left,key,val);
        if(cmp > 0) h.right = put(h.right,key,val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) +1;
        return h;
    }


    public Value get(Key key){

        return get(root,key);
    }

    /**
     * 查找
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        //以x为根节点的子树中查找并返回key对应的值。
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)return get(x.left,key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public boolean contains(Key key){

        Value val = get(key);
        if(val == null) return false;
        else return true;

    }

    public static void main(String[] args) {

        RedBlackBST<String,Integer> bst= new RedBlackBST<String,Integer>();

        bst.put("H",0);
        bst.put("E",1);
        bst.put("L",2);
        bst.put("L",3);
        bst.put("O",4);
        bst.put("W",5);
        bst.put("O",6);
        bst.put("R",7);
        bst.put("L",8);
        bst.put("D",9);

        int xx = bst.get("D");
        System.out.println("xx:"+xx);

        System.out.println("D:"+bst.contains("D"));
        System.out.println("A:"+bst.contains("A"));


    }


}
