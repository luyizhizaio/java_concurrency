package com.kyrie.datastructure.treeApplication;

import java.io.*;
import java.util.*;

/**
 * Created by tend on 2020/10/26.
 */
public class HuffmanCode4File {

    public static void main(String[] args) throws Exception {

        String srcFile ="E:\\huffman.txt";
        String dstFile ="E:\\huffman.txt.huf";
        String srcFile2 ="E:\\huffman2.txt";
        zipFile(srcFile,dstFile);
        unZipFile(dstFile,srcFile2);

    }


    public static void zipFile(String srcFile,String dstFile) throws Exception {

        FileInputStream is = new FileInputStream(srcFile);


        //创建和源文件大小一样的byte[]
        byte[] b = new byte[is.available()];

        //读取文件
        is.read(b);

        //直接对源文件压缩
        byte[] huffmanBytes = huffmanZip(b);

        //创建文件的输出流，存放压缩文件
        FileOutputStream os = new FileOutputStream(dstFile);

        ObjectOutputStream oos = new ObjectOutputStream(os);

        //把赫夫曼编码后的字节数组写入压缩文件
        oos.writeObject(huffmanBytes);

        //赫夫曼编码表写入压缩文件
        oos.writeObject(huffmanCodes);

        is.close();
        oos.close();
        os.close();
    }


    public  static void unZipFile(String zipFile,String dstFile) throws Exception {

        FileInputStream is = new FileInputStream(zipFile);

        ObjectInputStream ois = new ObjectInputStream(is);

        byte[] huffmanBytes = (byte[]) ois.readObject();

        Map<Byte,String> huffmanCode = (Map<Byte, String>) ois.readObject();


        byte[] decodeBytes = decode(huffmanCode, huffmanBytes);

        FileOutputStream os = new FileOutputStream(dstFile);

        os.write(decodeBytes);

        os.close();
        ois.close();
        is.close();
    }



    /**
     * 1.Huffman压缩：赫夫曼压缩流程代码
     * @param contentBytes
     * @return
     */
    private static byte[] huffmanZip(byte[] contentBytes){

        //1.创建NodeList
        List<Node> nodes = getNodes(contentBytes);

        //2.创建huffmanTree
        Node huffmanNode = createHuffmanTree(nodes);

        //3.生成huffmanTree编码表
        Map<Byte, String> huffmanCodesMap = getCodes(huffmanNode);

        //4.压缩成相应的字节码文件
        byte[] huffmanCodeByte = zip(contentBytes, huffmanCodesMap);

        return huffmanCodeByte;
    }

    //生成哈夫曼树对应的哈夫曼编码
    //将哈夫曼编码表存放在map<byte,string>
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //生成的哈夫曼编码需要去拼接路径，定义一个StringBuilder存储叶子节点路径
    static StringBuilder stringBuilder = new StringBuilder();

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

    /**
     * 构建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {

        while(nodes.size()> 1){

            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(null, leftNode.weight + rightNode.weight);

            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 生成赫夫曼编码，左子树为0，右子树为1；
     * @param root
     * @return
     */
    private static Map<Byte,String> getCodes(Node root){
        if(root == null){
            return null;
        }else{
            getCodes(root.left, "0", stringBuilder);

            getCodes(root.right, "1", stringBuilder);
        }


        return huffmanCodes;

    }


    /*
    * 将传入的node节点所有的叶子节点的哈夫曼树编码得到，并放入到huffmantree集合
    * node 传入节点
    * code 路径：左节点是0， 右节点1
    * stringBuilder 用于拼接路径
    * */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder sb2 = new StringBuilder(stringBuilder);

        sb2.append(code);

        if(node !=null){
            if(node.data == null){
                getCodes(node.left,"0",sb2);
                getCodes(node.right,"1",sb2);
            }else {
                huffmanCodes.put(node.data,sb2.toString());
            }

        }
    }


    /**
     * 压缩字节数组
     * 将字符串对应的byte[]数组，通过生成的哈夫曼树编码表，返回一个哈夫曼树编码压缩后的byte[]
     * @param bytes
     * @param huffmanCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte,String> huffmanCodes){

        StringBuilder stringBuilder = new StringBuilder();

        //把原字节替换成赫夫曼编码
        for(byte b : bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }


        //将二进制转为10进制保存再byte[]
        int len;
        if(stringBuilder.length() % 8==0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }

        //创建存储压缩byte数组
        byte[] by = new byte[len];
        int index =0;
        for (int i = 0; i < stringBuilder.length() ; i+=8) {
            String strByte;
            if(i +8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i,i+8);
            }
            by[index] = (byte)Integer.parseInt(strByte,2);
            index ++;
        }
        return by;
    }


    /**
     * 2.解压缩：反解huffman编码字符串
     * @param huffmanCodes
     * @param huffmanBytes
     * @return
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){

        //1.huffman数组反解成二进制字符串
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < huffmanBytes.length; i++) {

            byte b = huffmanBytes[i];

            //是否是最后一个字节
            boolean flag = (i == huffmanBytes.length -1);

            stringBuilder.append(byteToBitString(!flag,b));
        }

        //把Huffman编码表进行调换
        HashMap<String, Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        //把huffman编码转成原字节
        ArrayList<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length();) {

            int count =1;

            boolean flag = true;
            Byte b = null;
            while(flag){
                String key = stringBuilder.substring(i ,i+count);
                b = map.get(key);
                if(b == null){
                    count ++;
                }else{ //匹配到
                    flag = false;
                }
            }

            list.add(b);
            i += count;
        }
        //list 转成字节数组
        byte[] b = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }


    private static String byteToBitString(boolean flag, byte b) {
        //使用变量保存b
        int temp = b; //将b转成int
        //如果是正数我们还存在补高位
        if (flag){
            temp |= 256;//按位与256
        }
        //返回的是temp对应的二进制补码
        String str = Integer.toBinaryString(temp);
        //按照补码返回的
        if (flag){
            return str.substring(str.length() - 8); //按照补码返回的
        } else {
            return str;
        }
    }





}
