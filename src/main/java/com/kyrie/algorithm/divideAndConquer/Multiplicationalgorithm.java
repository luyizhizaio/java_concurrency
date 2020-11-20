package com.kyrie.algorithm.divideAndConquer;


/**
 * 大整数乘法
 * 思路来源：https://blog.csdn.net/weixin_43872728/article/details/101082875
 */
public class Multiplicationalgorithm {

    public static void main(String[] args) {
        long result =multiplication(1234,5678);

        System.out.println("result:"+result);
    }




    public static long multiplication(long numb1, long numb2){

        int column = (numb1+"").length() + (numb2+"").length();
        int row = (numb2+"").length();

        long[][] arr = new long[row][column];

        char [] chars = String.valueOf(numb2).toCharArray();

        int xx=0;
        for (int i = chars.length -1; i >=0; i--) {

            long n = Long.parseLong(chars[i]+"");

            long multi = n * numb1;

            char [] multiChars = String.valueOf(multi).toCharArray();

            for (int j = 0; j < multiChars.length; j++) {

                arr[i][column -multiChars.length +j-xx] =Long.parseLong(multiChars[j]+"");
            }
            xx++;

        }

        //累加二维数组

        long result =0L;

        for (int i = column -1; i >=0; i--) {

            long x= 0;
            for (int j = 0; j <row; j++) {

                x += arr[j][i];
            }
            result = result + (long)(x *(Math.pow(10,column-1-i)));
        }
        return result;
    }
}

