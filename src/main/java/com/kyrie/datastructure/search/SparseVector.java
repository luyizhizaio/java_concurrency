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
        for(Object i: st.keys()){
            sum += that[(int)i] * this.get((int)i);
        }
        return sum;

    }


    public static void main(String[] args) {

        int N =2;
        //稀疏矩阵与向量的乘法
        SparseVector [] a;
        a = new SparseVector[N];


        SparseVector a0 = new SparseVector();
        SparseVector a1 = new SparseVector();

        a0.put(0, 1.0);
        a0.put(1, 2.0);

        a1.put(0, 2.0);
        a1.put(1, 2.0);

        a[0] = a0;
        a[1] = a1;


        double[] x = {1.0,2.0};
        double[] b = {2.0,2.0};

        for(int i = 0; i< N;i++){
            b[i] = a[i].dot(x);
        }

        System.out.println(b);

    }


}
