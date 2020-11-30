package com.kyrie.algorithm.dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {

    public static void main(String[] args) {

        char[] vertex = {'A','B','C','D','E','F','G'};

        int[][] matrix =new int[vertex.length][vertex.length];

        final int N = 65535; //表示不能连接

        matrix[0] = new int[]{N,5,7,N,N,N,2};
        matrix[1] = new int[]{5,N,N,9,N,N,3};
        matrix[2] = new int[]{7,N,N,N,8,N,N};
        matrix[3] = new int[]{N,9,N,N,N,4,N};
        matrix[4] = new int[]{N,N,8,N,N,5,4};
        matrix[5] = new int[]{N,N,N,4,5,N,6};
        matrix[6] = new int[]{2,3,N,N,4,6,N};


        Graph graph = new Graph(vertex, matrix);

        graph.showGraph();

        graph.dsj(2);//传入初始顶点下标

        graph.showDijkstra();
    }

}


class Graph{

    private char[] vertex;
    private int[][] matrix;

    private VisitedVertex vv;//已经访问的顶点的集合

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }


    public void showGraph() {

        for (int[] link :matrix){
            System.out.println(Arrays.toString(link));
        }

    }

    /**
     * 迪杰斯特拉算法
     * @param index
     */
    public void dsj(int index) {

        vv =new VisitedVertex(vertex.length,index);
        update(index);//更新index顶点到周围顶点的距离和前驱

        for (int j = 0; j < vertex.length; j++) {

            index = vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱
        }
    }


    /**
     * 更新index顶点到周围顶点的距离和前驱
     * @param index
     */
    private void update(int index) {

        int len =0;

        for (int j = 0; j <matrix[index].length ; j++) {

            //len :出发顶点到index顶点距离+ 从index顶点到j顶点的距离
            len = vv.getDis(index) + matrix[index][j];

            //判断j顶点是否被访问，且
            if(!vv.visited(j) && len < vv.getDis(j)){
                //更新前驱
                vv.updatePre(j,index);

                //更新出发顶点到j顶点的距离
                vv.updateDis(j,len);
            }

        }
    }

    public void showDijkstra() {

        vv.show();
    }
}


/**
 * 访问的顶点
 */
class VisitedVertex{

    int[] alreadyArr; //记录各个顶点是否访问过，1访问过，0未访问
    int[] dis; //初始顶点到各个顶点距离
    int[] preVisited; //每个下标度应的值为前驱的顶点下标



    /**
     *
     * @param length 顶点个数
     * @param index 开始顶点下标
     */
    public VisitedVertex(int length, int index) {
        this.alreadyArr = new int[length];
        this.dis = new int[length];
        this.preVisited = new int[length];

        //初始化dis数组
        Arrays.fill(dis,65535);
        this.alreadyArr[index] = 1;
        this.dis[index] = 0;

    }


    public int getDis(int index) {

        return dis[index];
    }

    //判断顶点index是否被访问
    public boolean visited(int index) {

        return alreadyArr[index]==1;
    }

    //更新j的前驱为index
    public void updatePre(int j, int index) {
        preVisited[j] = index;

    }

    //更新初始顶点到j的距离为len
    public void updateDis(int j, int len) {

        dis[j] = len;

    }

    public int updateArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < alreadyArr.length; i++) {

            if(alreadyArr[i] == 0 && dis[i] < min){//广度优先遍历：选择没有被访问，并且是与已访问顶点的临近顶点
                min = dis[i];
                index = i;
            }
        }
        alreadyArr[index] = 1;
        return index;


    }
    //显示最终的结果,
    //输出三个数组
    public void show() {

        //alreadyArr
        for (int i:alreadyArr){
            System.out.print(i+" ");
        }

        System.out.println();


        for (int i:preVisited){
            System.out.print(i+" ");
        }

        System.out.println();


        for (int i:dis){
            System.out.print(i+" ");
        }

        System.out.println();


        char[] vertex = {'A','B','C','D','E','F','G'};

        int count = 0;

        for(int i : dis){

            if(i!= 65535){
                System.out.print(vertex[count] + "(" + i +")");
            }else{
                System.out.println("N ");

            }
            count++;
        }

        System.out.println();

    }
}
