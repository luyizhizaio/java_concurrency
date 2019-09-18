package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/16.
 */
public class SeparateChainHashST<Key,Value> {

    private int N; //键值对总数
    private int M; //散列表大小

    private SequentialSearchST<Key,Value>[] st; //存放链表对象的数组
    public SeparateChainHashST(){
        this(13);
    }


    public SeparateChainHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key,Value>[])new SequentialSearchST[M];
        for(int i =0; i<M ; i++){
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return st[hash(key)].get(key);
    }
    public void put (Key key ,Value val){
        st[hash(key)].put(key,val);
    }

    public void delete(Key key){
        st[hash(key)].delete(key);
    }

    public int size(){
        return 0;
    }


    public boolean contains(Key i) {

        return false;
    }


    public static void main(String[] args) {

        SeparateChainHashST<String,Integer> bst= new SeparateChainHashST<String,Integer>();

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
        System.out.println("D:"+xx);
        bst.delete("D");
        System.out.println("D:"+bst.get("D"));

    }


}
