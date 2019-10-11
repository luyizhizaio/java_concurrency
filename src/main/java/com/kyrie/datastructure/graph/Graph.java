package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.struct.linkedlist.Bag;
import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/9/23.
 * 邻接表数组实现图
 */
public class Graph {

    private int V; //顶点数量
    private int E; //边的数量

    private Bag<Integer>[] adj; //邻接表:Bag链式存储节点

    /**
     * 构造 V节点，没有边的图
     * @param V
     */
    public Graph(int V){

        adj = (Bag<Integer>[])new Bag[V];
        this.V = V;
        for(int v = 0 ; v <V ; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in){
        this(in.readInt()); //读取文件第一行
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
        adj[w].add(v);// w节点添加v-w的边
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

    public String toString(){
        String s = V +" vertices, " + E + " edges\n";
        for (int v = 0; v<V ; v++){
            s += v + ": ";
            for(int w :this.adj(v))
                s += w + " ";
            s+="\n";
        }
        return s;
    }

    public static int degree(Graph G ,int v){
        int degree =0;
        for (int w : G.adj(v)) degree ++;
        return degree;
    }

    public static int maxDegree(Graph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if(max < degree(G,v)) max =degree(G,v);
        }
        return max;
    }

    public static double avgDegree(Graph G){

        return 2 * G.E() /G.V();

    }

    /**
     * 自环的个数
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(Graph G){



        return 0;

    }



    public static void main(String[] args) {

        In in = new In(new File("data/tinyG.txt")); //读入文件流
        Graph graph = new Graph(in);

        System.out.println(graph.toString());

        int maxDegree = Graph.maxDegree(graph);
        System.out.println("maxDegree:" + maxDegree);


    }

}
