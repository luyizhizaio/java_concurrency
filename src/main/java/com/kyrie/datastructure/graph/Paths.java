package com.kyrie.datastructure.graph;

/**
 * Created by tend on 2019/9/29.
 * 寻找路径
 */
public class Paths {

    private Graph G;
    private int s;
    private DepthFirstPaths dfp;

    //找出所有起点为s的路径
    public Paths(Graph G,int s){
        this.G = G;
        this.s = s;
        dfp = new DepthFirstPaths(G,s);
    }

    //是否存在s到v的路径
    public boolean hasPathTo(int v){
        return dfp.marked(v);
    }

    public Iterable<Integer> pathTo(int v){

        return dfp.pathTo(v);
    }


    public static void main(String[] args) {

    }


}
