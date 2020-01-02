package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/10/18.
 * 使用两种颜色将图的所有顶点着色，使得任意一条边的两端点颜色不同，即：图是否为二分图
 * 使用深度优先遍历
 */
public class TwoColor {


    private boolean [] marked;
    private boolean[] colors; //记录顶点原色
    private Boolean TwoColor = true;

    public TwoColor(Graph G){
        marked = new boolean[G.V()];
        colors = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if(!marked[s])
                dfs(G,s,s);
        }
    }

    public void dfs(Graph G,int v,int u){
        colors[v] = !colors[u];
        marked[v] = true;
        for(int w: G.adj(v)){

            if(!marked[w]){
                dfs(G,w,v);
            }else if (w!= u && colors[w] == colors[u]){
                //是不是二分图
                TwoColor = false;
            }
        }
    }

    public boolean isTwoColor(){
        return TwoColor;
    }


    public static void main(String[] args) {

        In in = new In(new File("data/tinyCG2.txt")); //读入文件流
        Graph G = new Graph(in);
        System.out.println(G.toString());

        TwoColor twoColor = new TwoColor(G);

        System.out.println("isTwoColor:"+twoColor.isTwoColor());
    }



}
