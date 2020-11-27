package com.kyrie.algorithm.prim;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {

        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs =data.length;

        int[][] weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};


        MGraph graph = new MGraph(verxs);

        MinTree minTree = new MinTree();

        minTree.createGraph(graph,verxs,data,weight);

        minTree.showGraph(graph);

        char v= 'C';

        //普里姆算法-最小生成树
        minTree.prim(graph,v); //v 表示开始顶点

    }
}


/**
 * 最小生成树
 */
class MinTree{

    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight){

        graph.data= data;
        graph.weight = weight;


    }

    public void showGraph(MGraph graph){
        for (int[] link:graph.weight){
            System.out.println(Arrays.toString(link));
        }

    }


    public void prim(MGraph graph, char v){



    }
}

/**
 * 图
 */
class MGraph{
    int verxs; //图的节点个数
    char[] data; //存放节点数据
    int[][] weight;//存放边，使用邻接矩阵


    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

