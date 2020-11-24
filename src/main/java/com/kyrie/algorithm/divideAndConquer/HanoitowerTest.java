package com.kyrie.algorithm.divideAndConquer;

/**
 * 汉诺塔测试案例
 */
public class HanoitowerTest {

    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }

    private static void hanoiTower(int num, char a, char b, char c) {
        if(num ==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //1.把最上面的所有盘从a->c,移动过程中会用到c
            hanoiTower(num -1,a,c,b);
            //2.把最下面的盘 a->c
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把b塔的所有盘从b->c,移动过程中使用到a
            hanoiTower(num -1,b,a,c);
        }
    }
}
