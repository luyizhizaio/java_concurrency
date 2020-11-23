package com.kyrie.datastructure.sort;

import java.io.*;
import java.util.*;

/**
 * 小内存大文件排序: 50MB内存跑600MB的文件
 */
public class SmallMemoBigFileSort {


    public static void main(String[] args) throws Exception {

        //创建文件
        //createFile();

        //1.切分大文件，进行排序，输出小文件
        //readFileByLines("D:\\github\\easyJava\\data.txt");


        //2.多路归并来排序
        mergeSort();


    }

    /**
     * 多路归并来排序
     * @throws Exception
     */
    public static void mergeSort() throws Exception {

        int fileNum = 251;

        String outpath = System.getProperty("user.dir");
        outpath +="\\mergesort\\data.txt";
        System.out.println(outpath);
        FileWriter fileWriter = new FileWriter(outpath);

        BufferedReader[] readers = new BufferedReader[fileNum];
        Map<Integer, Integer> flags = new HashMap<Integer, Integer>();

        Integer[] ints = new Integer[fileNum];

        for (int i = 1; i <= fileNum ; i++) {
            String filepath = System.getProperty("user.dir");
            filepath +="\\split\\data"+i+".txt";
            System.out.println(filepath);

            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            readers[i -1] = reader;
        }

        while(flags.size() < fileNum){
            for (int i = 0; i < fileNum ; i++) {

                if(ints[i] == null && flags.get(i) == null){
                    String str = readers[i].readLine();
                    if(str !=null){
                        Integer num = Integer.parseInt(str);
                        ints[i] = num;
                    }else{ //子文件读取结束
                        flags.put(i,1);
                    }

                }
            }

            if(flags.size() == fileNum){
                break;
            }

            //找出最小的数字，写文件
            int min =0 ;
            int index = 0;

            for (int i = 0; i <ints.length ; i++) {

                if(ints[i] !=null){
                    min = ints[i];
                    index = i;
                    break;
                }

            }

            for (int i = 0; i <ints.length ; i++) {

                if(ints[i] != null && ints[i]< min){
                    min = ints[i];
                    index = i;
                }
            }

            if(min == 0 ){
                System.out.println("min："+min);
            }

            ints[index] = null;

            fileWriter.write(min +"\r\n");

        }
        fileWriter.close();

    }



    /**
     * 以行为单位读取文件
     */
    public static void readFileByLines(String fileName) {

        int fileNum = 1;

        ArrayList<Integer> list = new ArrayList<Integer>();

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                list.add(Integer.parseInt(tempString));
                line++;

                if(line % 200000 ==0){
                    //
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });

                    String filepath = System.getProperty("user.dir");
                    filepath +="\\split\\data"+fileNum+".txt";
                    System.out.println(filepath);

                    FileWriter fileWriter = new FileWriter(filepath);

                    list.forEach(n -> {
                        try {
                            fileWriter.write(n+"\r\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    fileWriter.close();
                    list = new ArrayList<Integer>();
                    fileNum ++;
                }
            }

            if(list.size() > 0){
                String filepath = System.getProperty("user.dir");
                filepath +="\\split\\data"+fileNum+".txt";
                System.out.println(filepath);

                FileWriter fileWriter = new FileWriter(filepath);

                list.forEach(n -> {
                    try {
                        fileWriter.write(n+"\r\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                fileWriter.close();
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

    /**
     * 创建文件
     * @throws Exception
     */
    public static void createFile () throws Exception {

        String filepath = System.getProperty("user.dir");
        filepath +="\\data.txt";
        System.out.println(filepath);

        try
        {
            File file = new File(filepath);
            if(!file.exists())
            {    //如果不存在data.txt文件则创建
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            FileWriter fw = new FileWriter(file);        //创建文件写入
            BufferedWriter bw = new BufferedWriter(fw);

            //产生随机数据，写入文件
            Random random = new Random();
            for(int i=0;i<50000000;i++)
            {
                int randint =(int)Math.floor((random.nextDouble()*1000000000.0));    //产生0-10000之间随机数
                bw.write(String.valueOf(randint));        //写入一个随机数
                bw.newLine();        //新的一行
            }
            bw.close();
            fw.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
