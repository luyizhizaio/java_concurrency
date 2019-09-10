package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/10.
 * 二叉查找树
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{

        private Key key;
        private Value val;
        private Node left,right;
        private int N; //以该节点为根的子树中的结点总数 =left(N) +right(N) +1

        public Node(Key key,Value val, int N){
            this.key = key;
            this.val = val;
            this.N= N;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node x) {
        if(x ==null)return 0;
        else return x.N;
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

    public void put(Key key,Value val){
        //查找key，扎到则更新它的值，否则为它创建一个新的节点。
        root =put(root,key,val);
    }

    private Node put(Node x, Key key, Value val) {

        if(x == null) return new Node(key,val,1);
        int cmp = key.compareTo(x.key);
        if(cmp <0) x.left = put(x.left,key,val); //如果key小于根节点的key，向左子树插入该key。
        else if (cmp > 0) x.right = put(x.right,key,val);
        else x.val = val;

        x.N = size(x.left) + size(x.right) +1;
        return x;
    }


    /**
     * 最小key
     * @return
     */
    public Key min(){

        return min(root).key;

    }

    private Node min(Node x) {
        if(x.left == null) return x;
        return min(x.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        return max(x.right);
    }

    /**
     * 小于key的最大key
     * @param key
     * @return
     */
    public Key floor(Key key){

        Node x = floor(root,key);
        if(x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null ) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t !=null) return t;
        else return x;
    }

    /**
     * 大于key最小的key
     * @param key
     * @return
     */
    public Key ceiling(Key key){
        Node x = ceiling(root,key);
        if(x == null) return null;
        return x.key;

    }

    private Node ceiling(Node x, Key key) {

        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0) return ceiling(x.right,key);
        Node t = ceiling(x.left,key);
        if(t !=null) return t;
        else return x;
    }

    /**
     * 返回排名为k的键
     * @param k
     * @return
     */
    public Key select(int k){
        return select(root,k).key;
    }

    private Node select(Node x, int k) {
        //
        if(x == null ) return null;
        int t = size(x.left);
        if(t > k)return select(x.left,k);
        else if (t <k) return select(x.right,k-t-1);
        else return x;

    }

    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        //返回以x为根节点的子树中小于x.key的键的数量
        if(x == null)return 0;
        int cmp = key.compareTo(x.key);
        if(cmp <0)return rank(key,x.left);
        else if (cmp >0) return 1 +size(x.left) +rank(key,x.right);
        else return size(x.left);

    }

    public void deleteMin(){

        root = deleteMin(root);

    }

    private Node deleteMin(Node x) {
        if(x.left == null) return x.right; //找到左子树为null为最小的node。
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }


    public void deleteMax(){
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left; //找到右子树为null为最大的node。
        x.right = deleteMax(x.right);
        x.N = size(x.left) +size(x.right) +1;
        return x;
    }


    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp <0 )x.left = delete(x.left,key);
        else if (cmp > 0) x.right = delete(x.right,key);
        else{ //找到要删除的node
            if(x.right == null)return x.left;
            if(x.left == null) return x.right;
            Node t =x;
            x=min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N= size(x.left)+ size(x.right) +1;
        return x;
    }

    public void print(Node x){
        if(x ==null)return;
        print(x.left);
        System.out.println(x.key);
        print(x.right);
    }


    public Iterable<Key> keys(){
        return keys(min(),max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {


        return null;

    }


    public static void main(String[] args) {

        BST<String,Integer> bst= new BST<String,Integer>();

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


        System.out.println("min:" + bst.min());
        System.out.println("max:" + bst.max());
        System.out.println("floor:" + bst.floor("X"));
        System.out.println("ceiling:" + bst.ceiling("I"));


        System.out.println("select:" + bst.select(3));
        System.out.println("rank:" + bst.rank("H"));
        bst.print(bst.root);
        // delete min
        bst.deleteMin();
        bst.print(bst.root);
        System.out.println("min:" + bst.min());
        bst.deleteMax();
        System.out.println("max:" + bst.max());

        bst.delete("H");
        System.out.println("rank:" + bst.rank("H"));

        bst.print(bst.root);
    }

}
