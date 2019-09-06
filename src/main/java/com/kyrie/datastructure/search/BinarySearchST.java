package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/6.
 * 平行数组实现二分查找
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity){
        keys = (Key[])new Comparable[capacity];
        vals = (Value[])new Comparable[capacity];
    }
    public int size(){
        return N;
    }
    public Value get(Key key){
        if(isEmpty()) return null;
        int i = rank(key);//获取key的下标
        if(i< N && keys[i].compareTo(key) ==0){
            return vals[i];
        }else{
            return null;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 返回key应该在keys中的位置
     * @param key
     * @return
     */
    public int rank(Key key){
        int lo = 0,hi = N-1;
        while(lo <= hi){
            int mid = lo + (hi -lo) /2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp <0) hi = mid -1;
            else if (cmp >0) lo = mid +1;
            else return mid;
        }
        return lo;
    }

    public void put(Key key,Value val){
        int i = rank(key);
        if(i<N && keys[i].compareTo(key) == 0){
            vals[i] = val; return;
        }

        //移动元素
        for(int j = N; j >i; j--){
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }

    public void delete(Key key){
        //TODO
    }


    public static void main(String[] args) {

        BinarySearchST<String,Integer> bs= new BinarySearchST<String,Integer>(100);
        //HELLOWORLD
        bs.put("H",0);
        bs.put("E",1);
        bs.put("L",2);
        bs.put("L",3);
        bs.put("O",4);
        bs.put("W",5);
        bs.put("O",6);
        bs.put("R",7);
        bs.put("L",8);
        bs.put("D",9);


        System.out.println("L:" + bs.get("L"));


    }



}
