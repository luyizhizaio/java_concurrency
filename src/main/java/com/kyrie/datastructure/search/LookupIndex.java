package com.kyrie.datastructure.search;

import com.kyrie.datastructure.struct.Queue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by tend on 2019/9/17.
 * 正序索引和反序索引
 */
public class LookupIndex {

    public static void main(String[] args) {

//        File file = new File(args[0]);
        File file = new File("data/lookup.index");
        BufferedReader reader = null;
//        String sp = args[1];
        String sp = ",";
        //正序索引
        RedBlackBST<String,Queue<String>> st = new RedBlackBST<String,Queue<String>>();

        //反序索引
        RedBlackBST<String,Queue<String>> ts = new RedBlackBST<String,Queue<String>>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;

                String[] a = tempString.split(sp);
                String key = a[0];
                for (int i = 1; i < a.length; i++) {
                    String val =a[i];
                    if(!st.contains(key))
                        st.put(key,new Queue<String>());
                    if(!ts.contains(val))
                        ts.put(val,new Queue<String>());

                    st.get(key).enQueue(val);
                    ts.get(val).enQueue(key);
                }
            }

            //接收标准输入
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入字符串：");
            while(true) {
                String query = scanner.nextLine();
                if(query.equals("exit")) break;
                System.out.println(">>>：" + query);


                if(st.contains(query)){
                    for(String s : st.get(query)){
                        System.out.println("    "+s);
                    }
                }
                if(ts.contains(query)){
                    for (String s:ts.get(query)){
                        System.out.println("    " +s);
                    }
                }



            }


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

    }



}
