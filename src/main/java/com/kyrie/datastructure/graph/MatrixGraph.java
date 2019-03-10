package com.kyrie.datastructure.graph;

/**
 * Created by Kyrie on 2019/1/5.
 * 邻接矩阵实现图
 * 1.最短路径-迪杰斯特拉算法
 */
public class MatrixGraph {

    public static final boolean UNDIRECTED_GRAPH = false;//无向图
    public static final boolean DIRECTED_GRAPH = true;//有向图

    public static final boolean ADJACENCY_MATRIX = true;//邻接矩阵实现
    public static final boolean ADJACENCY_LIST = false;//邻接表实现
    public static final int INF = Integer.MAX_VALUE;
    private boolean graphType;//图类型
    private boolean implementation;//实现方式


    private int vertexNum;//顶点数
    private int mEdgeNum;// 边数
    private Object[]  vertices; //顶点集合
    private int[][] edgeMatrix;//邻接矩阵


    public MatrixGraph(boolean graphType, boolean implementation, int size){


        this.graphType = graphType;
        this.implementation = implementation;
        this.vertexNum = 0; //初始时为0个结点。
        this.mEdgeNum = 0;

        int maxVertexNum = size;//
        if(this.implementation){
            vertices = new Object[maxVertexNum];
            edgeMatrix = new int[maxVertexNum][maxVertexNum];
            for(int row = 0 ; row < edgeMatrix.length; row++){
                for (int column =0; column < edgeMatrix.length; column++){
                    edgeMatrix[row][column] = INF;
                }
            }
        }

    }

    public boolean addVertex(Object vertex){
        assert(vertex !=null);
        vertices[vertexNum] = vertex;
        vertexNum ++;
        return true;

    }

    public boolean addEdge(int src, int dst, int weight){
        assert(src >= 0 && dst >= 0 && src != dst && weight >= 0);

        if(graphType){ //有向图
            this.mEdgeNum +=1;
            edgeMatrix[src][dst] = weight;
        }else{ //
            this.mEdgeNum +=2;
            edgeMatrix[src][dst]=weight;
            edgeMatrix[dst][src]=weight;
        }
        return true;
    }



    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     matrix-- 矩阵(数据)
     */
    public MatrixGraph(Object[] vexs, int[][] matrix) {

        // 初始化"顶点数"
        this.vertexNum = vexs.length;

        // 初始化"顶点"
        this.vertices = new Object[vertexNum];
        for (int i = 0; i < vertexNum; i++)
            vertices[i] = vexs[i];

        // 初始化"边"
        this.edgeMatrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++)
            for (int j = 0; j < vertexNum; j++)
                edgeMatrix[i][j] = matrix[i][j];

        this.mEdgeNum=0;
        for (int i = 0; i < vertexNum; i++)
            for (int j = i+1; j < vertexNum; j++)
                if (edgeMatrix[i][j]!=INF)
                    mEdgeNum++;

    }



    /**
     * 迪杰斯特拉算法
     * @param obj
     * @throws Exception
     */
    public void Dijkstra(Object obj) throws Exception {

        int vertexIndex = getVertexIndex(obj);
        Dijkstra(vertexIndex);

    }

    public void Dijkstra(int v0){
        // 前驱顶点数组。即，prev[i]的值是"顶点v0"到"顶点i"的最短路径所经历的全部顶点中位于"顶点i"之前的那个顶点。
        int[] prev = new int[vertexNum];
        //长度数组。即，dist[i]是"顶点v0"到"顶点i"的最短路径的长度。
        int[] dist = new int[vertexNum];

        //标记是否被访问
        boolean[] flag=new boolean[vertexNum];

        for(int i =0; i< vertexNum; i++){
            flag[i] = false; //顶点i的最短路径还没获取到
            dist[i] = edgeMatrix[v0][i]; // 顶点i的最短路径为"顶点v0"到"顶点i"的权。

            //直达情况下的最后经由点就是出发点
            if (i != v0 && dist[i] < INF)
                prev[i] = v0;
            else
                prev[i] = -1; //无直达路径

        }
        flag[v0] = true;
        dist[v0] = 0;

        int v =0; //中间结点
        for(int i =1; i < vertexNum; i++){
            int min = INF; //
            for(int j = 0 ; j < vertexNum; j++){
                if( !flag[j] && dist[j] < min){
                    min = dist[j]; //最小距离
                    v = j; // 经由顶点j中转则距离更短
                }
            }
            flag[v] = true;

            /*顶点v并入S，由v0到达v顶点的最短路径为min.
              假定由v0到v，再由v直达其余各点，更新当前最后一个经由点及距离*/
            for(int j =0; j< vertexNum; j++){
                if(!flag[j] && edgeMatrix[v][j] < INF){
                    if( min + edgeMatrix[v][j] <= dist[j]){
                        dist[j] = min + edgeMatrix[v][j];
                        prev[j] = v;
                    }
                }

            }


        }
        for(int i = 1; i< vertexNum;i++){

            System.out.println("**" + vertices[v0] + "-->" +vertices[i] + " 的最短路径是：" + dist[i]);

        }


    }

    private int getVertexIndex(Object obj) throws Exception {
        int index = -1;
        for(int i =0; i< vertexNum; i++){
            if(vertices[i].equals(obj)){
                index =i;
                break;
            }
        }
        if(index ==-1){
            throw new Exception("no this vertex");
        }
        return index;
    }



    /*
    * 打印矩阵队列图
    */
    public void print() {
        System.out.printf("Martix Graph:\n");
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++)
                System.out.printf("%10d ", edgeMatrix[i][j]);
            System.out.printf("\n");
        }
    }




    public static void main(String[] args) throws Exception {

        MatrixGraph graph = new MatrixGraph(MatrixGraph.UNDIRECTED_GRAPH, MatrixGraph.ADJACENCY_MATRIX, 6);

        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");

        graph.addEdge(0, 1,7);
        graph.addEdge(0, 2,9);
        graph.addEdge(0, 5,14);

        graph.addEdge(1, 3,15);
        graph.addEdge(1, 2,10);

        graph.addEdge(2, 3,11);
        graph.addEdge(2, 5,2);

        graph.addEdge(3, 4,6);
        graph.addEdge(4, 5,9);
        graph.Dijkstra("1");

        graph.print();


        Object[] vexs = {"A", "B", "C", "D", "E", "F", "G"};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        MatrixGraph pG = new MatrixGraph(vexs, matrix);

        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树
        //pG.kruskal(); // Kruskal算法生成最小生成树


        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        pG.Dijkstra("A");


    }

}
