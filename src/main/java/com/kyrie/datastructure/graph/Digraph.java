package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.struct.linkedlist.Bag;
import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/12/10.
 * 有向图
 */
public class Digraph {
    private int V;
    private int E;
    private Bag<Integer> [] adj;

    public Digraph(int V){

        adj = (Bag<Integer>[])new Bag[V];
        this.V = V;
        for(int v = 0 ; v <V ; v++){
            adj[v] = new Bag<Integer>();
        }


    }
    public Digraph(In in){
        this(in.readInt());
        int E =in.readInt();
        for(int e =0 ; e<E; e++){
            //添加一条边
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }

    }

    /**
     * 添加边
     * @param v
     * @param w
     */
    private void addEdge(int v, int w) {
        adj[v].add(w);// v节点添加v-w的边
        E++;
    }

    public int V(){return V;}
    public int E(){return E;}

    /**
     * 返回Bag
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){
       Digraph R = new Digraph(V);

        for(int v =0; v < V; v++){
            for(int w: this.adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }


    public static void main(String [] args){
        In in = new In(new File("data/tinyG.txt")); //读入文件流
        Graph graph = new Graph(in);

        System.out.println(graph.toString());
    }

}
