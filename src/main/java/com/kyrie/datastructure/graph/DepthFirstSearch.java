package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.utils.In;
import com.kyrie.datastructure.utils.StdOut;

import java.io.File;

/**
 * Created by tend on 2019/9/25.
 * 深度优先搜索(DFS):递归方法遍历所有顶点。访问其中一个顶点时，将其标记为已访问，递归地访问它所有没有被标记过的邻居顶点。
 */
public class DepthFirstSearch {
    //0节点作为起点。


    private boolean[] marked ;
    private int count;
    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    /**
     * 深度优先搜索方法
     */
    private void dfs(Graph G,int v){
        marked[v] =true;
        count ++;
        for(int w : G.adj(v)){
            if(!marked[w]) dfs(G,w);
        }
    }
    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }


    public static void main(String[] args) {

        In in = new In(new File("data/tinyCG.txt")); //读入文件流
        Graph G = new Graph(in);
        System.out.println(G.toString());

        DepthFirstSearch dfs = new DepthFirstSearch(G,0);
        System.out.println("count:" + dfs.count());


        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                StdOut.print(v + " ");
        }

        StdOut.println();
        if (search.count() != G.V()) StdOut.println("NOT connected");
        else                         StdOut.println("connected");

    }




}
