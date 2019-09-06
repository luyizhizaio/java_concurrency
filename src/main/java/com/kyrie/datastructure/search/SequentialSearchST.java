package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/6.
 * 无序链表的顺序查找
 */
public class SequentialSearchST<Key,Value> {

    private Node first;

    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    public Value get(Key key){
        for(Node x = first; x!=null;x = x.next){ //顺序搜索
            if(key.equals(x.key))
                return x.val;
        }
        return null;
    }

    public void put (Key key , Value val){
        for(Node x = first; x !=null ; x = x.next){ //顺序搜索
            if(key.equals(x.key)){
                x.val = val; return;
            }
            first = new Node(key,val,first);//未命中，新建节点，头插法
        }
    }

    public int size(){
        int size = 0;
        for(Node x =first ;x !=null ; x = x.next){
            size +=1;
        }
        return size;
    }


    public void delete(Key key){
        Node pre = null;
        for(Node x = first; x!=null;x=x.next){

            if(key.equals(x.key)){
                pre.next = x.next;
            }
            pre = x;
        }


    }



}
