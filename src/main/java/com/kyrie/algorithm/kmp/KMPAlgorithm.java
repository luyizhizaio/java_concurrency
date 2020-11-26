package com.kyrie.algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {

    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";

        String str2 = "ABCDABD";
        //String str2 ="AAAB";

        //1.根据字串生成部分匹配表
        int[] table = partialMatchTable(str2);

        System.out.println("partialMatchTable:"+ Arrays.toString(table));

        //2.完成匹配
        int i = kmpSearch(str1, str2, table);

        System.out.println("index:" +i);


    }

    /**
     * kmp搜索
     * @param str1
     * @param str2
     * @param table
     * @return
     */
    public static int  kmpSearch(String str1,String str2 , int[] table){


        for (int i = 0,j = 0; i < str1.length() ; i++) {

            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                j = table[j -1];
            }

            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            //匹配到
            if(j == str2.length()){
                return i -j +1;
            }
        }
        return -1;
    }


    /**
     * 生成部分匹配表
     * @param str2
     * @return
     */
    public static int[] partialMatchTable(String str2){


        int[] table = new int[str2.length()];

        table[0]=0;
        //i,j 分别用于str2自己跟自己做比较
        for (int i = 1,j = 0; i < str2.length() ; i++) {

            while(j>0 && str2.charAt(i) !=str2.charAt(j)){
                j = table[j-1];
            }
            //ABCDABD ；AA
            if(str2.charAt(i) == str2.charAt(j)){
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    /**
     * 大跃自己实现的生成部分匹配表
     * @param str2
     * @return
     */
    public static int[] partialMatchTable2(String str2){
        /*
        根据前缀和后缀共同元素的长度来表示部分匹配值：
    "部分匹配值"就是"前缀"和"后缀"的最长的共有元素的长度。以"ABCDABD"为例，看前缀和后缀共有的元素长度。

　　－　"A"的前缀和后缀都为空集，共有元素的长度为0；

　　－　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；

　　－　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；

　　－　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；

　　－　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；

　　－　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；

　　－　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
         */

        int[] table = new int[str2.length()];

        table[0] = 0;

        for (int i = 1,j=0; i <= str2.length(); i++) {
            String subStr = str2.substring(0,i);


            for (int k = 1; k < subStr.length(); k++) {

                String prefix = subStr.substring(0,k);
                String postfix = subStr.substring(subStr.length() - k);

                if(prefix.equals(postfix)){
                    j = prefix.length();
                }
            }

            table[i-1] = j;
            j=0;

        }

        return table;
    }

}
