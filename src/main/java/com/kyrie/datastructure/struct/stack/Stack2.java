package com.kyrie.datastructure.struct.stack;

/**
 * 带头节点的链栈；
 * Created by Kyrie on 2017/7/20.
 * 栈：先进后出，
 * 栈分为顺序栈和链栈，
 *
 */
public class Stack2 {

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

    public Stack2(){
        lst = new LNode(null);//创建头结点。

    }

    //判空
    public boolean isEmpty(){
        if(this.lst.next ==null){
            return true;
        }else{
            return false;
        }
    }
    //进栈
    public int push(String x){
        LNode p = new LNode(x);

        p.next = this.lst.next;
        this.lst.next = p;
        return 1;

    }


    //出栈
    public String pop(){

        if(this.lst.next == null){
            return "0"; //空栈
        }

        LNode p = this.lst.next;
        String x = p.data;

        this.lst.next = p.next;
        p=null;
        return x;
    }





    public static void main(String[]args){
        Stack2 stack2 = new Stack2();

        System.err.println("empty:"+stack2.isEmpty());

        for(int i = 0; i<11 ;i++){
            System.out.println("push i="+i);
            stack2.push("x"+i);
        }

        System.err.println("empty:"+stack2.isEmpty());


        for(int i = 0; i<11 ;i++){

            String x = stack2.pop();
            System.out.println("pop x="+x);
        }

    }


}
