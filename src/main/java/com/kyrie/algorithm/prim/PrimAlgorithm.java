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


        //创建图
        MGraph graph = new MGraph(verxs);

        //创建最小生成树
        MinTree minTree = new MinTree();

        //构造图
        minTree.createGraph(graph,verxs,data,weight);
        //展示图
        minTree.showGraph(graph);

        //初始顶点
        int v = 2;

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


    /**
     *
     * @param graph
     * @param v 表示从图的第几个顶点开始生成
     */
    public void prim(MGraph graph, int v){

        //是否访问节点
        int[] visited = new int[graph.verxs];

        for (int i = 0; i <visited.length; i++) {
            visited[i] = 0;
        }

        visited[v] = 1;

        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;

        int minWeight = 10000;

        for (int k = 1; k < graph.verxs; k++) {//有n个顶点，n-1条边


            for (int i = 0; i <graph.verxs; i++) {//i 表示访问过的节点
                int visitedV = visited[i];

                for (int j = 0; j < graph.verxs; j++) { //未访问的节点


                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j]<minWeight){

                        minWeight = graph.weight[i][j];

                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //找到一最小的一条边
            System.out.println("边<" +graph.data[h1]+","+graph.data[h2] +">权值："+minWeight);

            visited[h2] = 1;
            minWeight =10000;

        }


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

