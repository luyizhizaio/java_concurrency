package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.search.BinarySearchST;

/**
 * Created by tend on 2019/10/18.
 * 符号图：在顶点是字符串。每一行两个顶点按分指定的隔符分开代表一条边。
 */
public class SybmolGraph {

    private BinarySearchST<String,Integer> st;

    private Graph G;

    private Integer[] keys; //index 找 vertex name



    public SybmolGraph(String fineName,String delim){



    }

    public boolean contains(String key){
        return false;
    }

    /**
     * 顶点名称转化为索引
     * @param key
     * @return
     */
    public int index(String key){
        return 0;
    }

    /**
     * 索引转化成顶点名称
     * @param index
     * @return
     */
    public String name(int index){
        return "";
    }

    public Graph G(){
        return null;
    }



    public static void main(String[] args) {



    }


}
