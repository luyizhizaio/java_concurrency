package com.kyrie.algorithm.kmp;

/**
 * 暴力匹配
 */
public class ViolenceMatch {

    public static void main(String[] args) {

        String str1 = "ababcabcdabcdef";
        String str2="abcde";

        int i = violenceMatch(str1, str2);

        System.out.println("i="+i);

    }

    public static int violenceMatch(String str1,String str2){

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int i=0,j=0;

        while(i<chars1.length && j<chars2.length){

            if(chars1[i] == chars2[j]){
                i++;
                j++;
            }else{
                i = i -(j -1);//从第二位重新匹配
                j=0;
            }
        }

        //匹配成功
        if(j == chars2.length){
            return i-j;
        }
        return -1;
    }


}
