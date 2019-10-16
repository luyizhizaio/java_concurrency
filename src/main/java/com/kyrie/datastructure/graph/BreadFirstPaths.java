package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.struct.linkedlist.Queue;
import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/10/15.
 * 广度优先遍历
 */
public class BreadFirstPaths {

    //到达该顶点的最短路径已知吗？
    private boolean[]  marked;



    private Integer edgeTo [];
    private int s;

    public BreadFirstPaths(Graph G, int s){
        edgeTo = new Integer[G.V()];
        marked =new  boolean[G.V()];
        this.s = s;
        bfs(G, s);
    }

    /**
     * 广度优先搜索方法
     */
    private void bfs(Graph G,int s){

        //保存所有被标记过但其邻接表还未被检查的顶点
        Queue<Integer> queue = new Queue<Integer>();

        queue.enqueue(s);
        marked[s] =true;
        while(!queue.isEmpty()) {
            Integer v = queue.dequeue();

            for (int w : G.adj(v)) {
                if(!marked[w]){
                    edgeTo[w] = v; //保存最短路径的最后一条边
                    marked[w] =true;//标记，因为最短路径已知
                    queue.enqueue(w); //相邻所有顶点加入队列。
                }

            }
        }
    }

    public boolean hasPathTo(Integer v){
        return marked[v];
    }

    public String pathTo(Integer v){
        String path = v + "";
        while (edgeTo[v] !=null) {
            Integer tmp = edgeTo[v];
            path = tmp + "-" + path;
            if(s == tmp){
                return path;
            }
            v = tmp;
        }
        return null;
    }




    public static void main(String[] args) {

        In in = new In(new File("data/tinyCG.txt")); //读入文件流
        Graph G = new Graph(in);
        System.out.println(G.toString());
        BreadFirstPaths bfs = new BreadFirstPaths(G,0);

        System.out.println(bfs.hasPathTo(4));
        System.out.println(bfs.pathTo(4));

        for(int i =1 ; i <=5 ;i++ ){
            System.out.println("0 to "+i+": " + bfs.pathTo(i));

        }



    }


}
