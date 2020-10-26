package com.kyrie.datastructure.treeApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tend on 2020/10/26.
 * 赫夫曼编码压缩和解压字符串
 */
public class HuffmanCode4String {

    public static void main(String[] args) {


        String str="nihaos";

        System.out.println(str.getBytes());


        buildHuffmanCode();





    }

    /**
     * 字节数组转成Node的集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<Node>();

        HashMap<Byte, Integer> counts = new HashMap<>();

        for (byte b :bytes){
            Integer count = counts.get(b);
            if(count ==null){
                counts.put(b,1);
            }else{
                counts.put(b,count +1);
            }
        }

        //把每一个键值转化成Node对象，加入nodes集合
        for(Map.Entry<Byte ,Integer> entry: counts.entrySet()){
            Node node = new Node(entry.getKey(), entry.getValue());
            nodes.add(node);
        }

        return nodes;
    }


    private static void buildHuffmanCode() {


    }




}
