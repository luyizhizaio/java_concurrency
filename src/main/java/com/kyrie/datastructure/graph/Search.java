package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.utils.In;

import java.awt.font.GlyphMetrics;
import java.io.File;

/**
 * Created by tend on 2019/9/25.
 * 找到与起点s联通的所有顶点
 */
public class Search {

    private Graph G;
    private int s;
    private DepthFirstSearch dfs;

    /**
     * 构造函数
     * @param G
     * @param s
     */
    public Search(Graph G, int s){
        this.G=G;
        this.s=s;
        dfs = new DepthFirstSearch(G,s);
    }

    /**
     * v是否与s联通
     * @param v
     * @return
     */
    public boolean Marked(int v){
        /**
         * 使用深度优先搜索（DFS）
         */
        return dfs.marked(v);
    }

    /**
     * 与s联通的定点总数
     * @return
     */
    public int count (){
        return dfs.count();
    }



}
