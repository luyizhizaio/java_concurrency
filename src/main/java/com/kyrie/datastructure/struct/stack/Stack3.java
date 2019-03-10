package com.kyrie.datastructure.struct.stack;

/**
 * 不带头节点的链栈；
 * Created by Kyrie on 2017/7/20.
 * 栈：先进后出，
 * 栈分为顺序栈和链栈，
 *
 */
public class Stack3 {

    private LNode lst;//头结点

    //结点定义
    static class LNode {
        String data; //数据域
        LNode next; //下一个结点的引用

        LNode(String data, LNode next){
            this.data = data;
            this.next = next;
        }
        LNode(String data){
            this(data,null);
        }
    }

    public Stack3(){


    }

    //判空
    public boolean isEmpty(){
        if(this.lst ==null){
            return true;
        }else{
            return false;
        }
    }
    //进栈
    public int push(String x){
        LNode p = new LNode(x);

        p.next =this.lst;
        this.lst = p;
        return 1;

    }


    //出栈
    public String pop(){

        if(this.lst == null){
            return "0"; //空栈
        }

        LNode p = this.lst;
        String x = p.data;

        this.lst = p.next;
        p=null;
        return x;
    }





    public static void main(String[]args){
        Stack3 stack3 = new Stack3();

        System.err.println("empty:" + stack3.isEmpty());

        for(int i = 0; i<11 ;i++){
            System.out.println("push i="+i);
            stack3.push("x" + i);
        }

        System.err.println("empty:" + stack3.isEmpty());


        for(int i = 0; i<11 ;i++){

            String x = stack3.pop();
            System.out.println("pop x="+x);
        }

    }


}
