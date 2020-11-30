package com.kyrie.algorithm.floyd;

import java.util.Arrays;

/**
 * 弗洛伊德算法-三层for循环实现
 */
public class FloydAlgorithm {

    public static void main(String[] args) {

        char[] vertex = {'A','B','C','D','E','F','G'};

        int[][] matrix =new int[vertex.length][vertex.length];

        final int N = 65535; //表示不能连接

        matrix[0] = new int[]{0,5,7,N,N,N,2};
        matrix[1] = new int[]{5,0,N,9,N,N,3};
        matrix[2] = new int[]{7,N,0,N,8,N,N};
        matrix[3] = new int[]{N,9,N,0,N,4,N};
        matrix[4] = new int[]{N,N,8,N,0,5,4};
        matrix[5] = new int[]{N,N,N,4,5,0,6};
        matrix[6] = new int[]{2,3,N,N,4,6,0};

        Graph graph = new Graph(vertex.length, matrix, vertex);
        
        graph.floyd();

        graph.show();

    }
}


class Graph{

    private char[] vertex;//存放顶点的数组
    private int[][] dis ; //保存从各顶点出发到其他顶点的距离，最后的结果也保存在该数组中
    private int[][] pre;//保存到达目标顶点的前驱顶点


    public Graph(int length, int[][] matrix, char[] vertex) {

        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);//初始化前驱顶点
        }
    }

    //三层for
    public void floyd() {

        int len = 0; //保存距离变量

        //计算出 i-k-j 的距离
        for (int k =0;k< dis.length;k++){//k 作为中间顶点
            for (int i = 0; i < dis.length; i++) { //i作为开始顶点
                for (int j = 0; j < dis.length; j++) { //j作为终止顶点
                    //len 表示从i顶点出发，经过k到达j顶点的距离
                    len = dis[i][k] + dis[k][j];
                    if(len < dis[i][j]){
                        dis[i][j] = len; //更新距离
                        pre[i][j] = pre[k][j];//更新前驱顶点
                    }

                }
            }
        }
    }

    public void show() {


        for (int k = 0; k < dis.length; k++) {
            System.out.println("--------------------------------");
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]]+ " ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.println("("+vertex[k]+"到"+vertex[i]+"的最短路径是"+dis[k][i] +")");

            }

            System.out.println();
            System.out.println();

        }
    }
}