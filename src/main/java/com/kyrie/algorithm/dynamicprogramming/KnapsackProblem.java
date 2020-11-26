package com.kyrie.algorithm.dynamicprogramming;

/**
 * 动态规划：0-1背包问题
 */
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] w = {1,4,3};//物品重量
        int[] val = {1500,3000,2000};//物品价值
        int m = 4 ;//背包容量
        int n = val.length;//物品的个数

        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][]v = new int[n+1][m+1];

        //为了记录放入商品的情况，
        int[][]path = new int[n+1][m+1];


        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//第一列设置为0
        }

        for (int i = 0; i < v.length; i++) {
            v[0][i] = 0;//第一行设置为0
        }

        //在矩阵中放入物品
        for (int i = 1; i < v.length; i++) {  //i放入的商品编号

            for (int j = 1; j < v[0].length; j++) { //j为可放的容量

                if(w[i-1] > j){//可放容量小于物品容量，矩阵下一个格子就等于上一个格子的值。
                    v[i][j] = v[i -1][j];
                } else { //可用容量大于物品容量，

                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){ //j-w[i-1] 表示去掉i-1商品剩余可用容量
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }


            }

        }

        //输出
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] +" ");
            }

            System.out.println();

        }


        System.out.println("--------------------------------");



        int i = path.length -1;
        int j = path[0].length -1;
        while(i>0 && j>0){

            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包\n",i);
                j -=w[i-1];
            }
            i--;
        }
    }


}
