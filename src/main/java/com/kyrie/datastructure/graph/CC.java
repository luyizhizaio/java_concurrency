package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.struct.linkedlist.Bag;
import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/10/16.
 * 连通分量，connect component：就是图连通起来的子图就叫连通分量
 */
public class CC {

    private boolean [] marked;//标记是否被访问
    private int [] id; //顶点作为索引，值为连通分量编号

    private int count; //连通分量数量

    private Graph G;

    public CC(Graph G){
        this.G = G;
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for(int i = 0; i<G.V(); i++){
            if(!marked[i]){
                dfs(G,i);
                count ++;
            }

        }
    }

    public void dfs(Graph G,int v){
        marked[v] =true;
        id[v] =count;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    /**
     * v,w是否连通
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * 连通分量数
     * @return
     */
    public  int count(){
        return count;
    }

    /**
     * v所在连通分量编号
     * @return
     */
    public int id(int v){

        return id[v];
    }

    public static void main(String[] args) {

        In in = new In(new File("data/tinyG.txt")); //读入文件流
        Graph G = new Graph(in);
        //System.out.println(G.toString());

        CC cc = new CC(G);

        int M = cc.count();

        System.out.println("component number:"+M);

        System.out.println("1 to 12 connect: " + cc.connected(1, 12));

        Bag<Integer> [] components = (Bag<Integer>[])new Bag[M];

        for(int i =0 ; i< M ;i++){
            components[i] = new Bag<Integer>();
        }

        for(int i = 0 ; i< G.V(); i ++){
            components[cc.id(i)].add(i);
        }

        for(int i = 0 ; i< M ; i++){
            System.out.print(i +":");
            for(int v: components[i]){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
