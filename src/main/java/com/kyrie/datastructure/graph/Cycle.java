package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/10/17.
 * 是否为无环图
 */
public class Cycle {


    private boolean [] marked ; //是否被访问
    private Graph G;
    private boolean hasCycle;

    public Cycle(Graph G){
        this.G = G;
        marked = new boolean[G.V()];
        for (int s = 0; s <G.V() ; s++) {
            if(!marked[s]){
                dfs(G,s,s);
            }
        }
    }


    public void dfs(Graph G,int v,int u){

        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                dfs(G,w,v);
            } else if(w != u) hasCycle = true; //找到被访问过的顶点，且不是父顶点
        }
    }


    public boolean hasCycle(){
        return hasCycle;
    }


    public static void main(String[] args) {
        In in = new In(new File("data/tinyCG.txt")); //读入文件流
        Graph G = new Graph(in);
        System.out.println(G.toString());

        Cycle cycle = new Cycle(G);

        System.out.println("hasCycle:"+cycle.hasCycle());


    }





}
