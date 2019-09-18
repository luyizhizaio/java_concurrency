package com.kyrie.datastructure.search;

/**
 * Created by tend on 2019/9/18.
 * 使用拉链法散列表实现稀疏向量
 * 用稀疏向量数组表示矩阵
 */
public class SparseVector {

    private LinearProbingHashST<Integer,Double> st;

    public SparseVector(){
        st = new LinearProbingHashST<Integer,Double>();
    }

    public int size(){
        return st.size();
    }

    public void put (int i , double x){
        st.put(i,x);
    }

    public double get (int i){
        if(!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    /**
     * 点乘
     * @param that
     * @return
     */
    public double dot(double[] that){
        double sum = 0.0;
        for(int i: st.keys()){
            sum += that[i]*this.get(i);
        }
        return sum;

    }


    public static void main(String[] args) {

        int N =2;

        SparseVector [] a;
        a = new SparseVector[N];
        double[] x = new double[N];
        double[] b = new double[N];



        for(int i = 0; i< N;i++){
            b[i] = a[i].dot(x);
        }

    }


}
