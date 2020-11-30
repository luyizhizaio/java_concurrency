package com.kyrie.algorithm.Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 科里斯卡尔算法-最小生成树（公交站问题）
 */
public class KruskalAlgorithm {


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


        //普里姆算法-最小生成树
        minTree.kruskal(graph); //v 表示开始顶点

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
     * 克鲁斯卡尔算法
     * @param graph
     */
    public void kruskal(MGraph graph) {

        //1.权值排序，加入最小权值的边，判断是否产生回路

        int[][] weight = graph.weight;

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < graph.verxs; i++) {

            for (int j = i +1; j < graph.verxs; j++) {
                if(weight[i][j]< 10000){
                    Edge edge = new Edge(i, j, weight[i][j]);
                    edges.add(edge);
                }
            }

        }

        System.out.println(edges.size());
        System.out.println(edges.toString());

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        //2.加入最小权值的边，判断是否产生回路

        //保存已选择的边
        ArrayList<Edge> R = new ArrayList<>();

        //保存每个顶点的终点
        int[] ends = new int[edges.size()];


        for (int i = 0; i < edges.size(); i++) {//选择n-1条边

            //判断是否产生回路
            Edge edge = edges.get(i);

            int v1 = edge.v1;
            int v2 = edge.v2;


            int end1 = getEnd(ends, v1);
            int end2 = getEnd(ends, v2);

            //没有回路
            if(end1 != end2){
                R.add(edge);
                //更新终点
                ends[end1] = end2;
            }

        }

        System.out.println("R"+R.toString());


    }

    /**
     * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同
     * @param ends 记录各个顶点对应的终点。
     * @param i
     * @return
     */
    private int getEnd(int[] ends, int i){

        while(ends[i]!=0){ //使用while循环，不断的获取最大的终点。
            i = ends[i];
        }

        return i;

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

class Edge{
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", weight=" + weight +
                '}';
    }
}
