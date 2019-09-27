package com.kyrie.datastructure.graph;

import com.kyrie.datastructure.utils.In;

import java.io.File;

/**
 * Created by tend on 2019/9/27.
 */
public class TestSearch {


    public static void main(String[] args) {
        In in = new In(new File("data/tinyG.txt")); //读入文件流
        Graph G = new Graph(in);
        Search search = new Search(G,0);

        for (int v = 0; v < G.V(); v++) {
            if(search.Marked(v)){
                System.out.print(v + " ");
            }
            System.out.println();
        }

        if(search.count() !=G.V()){
            System.out.print("NOT ");
        }
        System.out.println("connected");

    }

}
