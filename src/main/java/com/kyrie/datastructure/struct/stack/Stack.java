package com.kyrie.datastructure.struct.stack;

/**
 * 顺序栈
 * Created by Kyrie on 2017/7/20.
 * 栈：先进后出，
 * 栈分为顺序栈和链栈，
 *
 */
public class Stack {

    public int maxSize = 100;
    public String[] data = new String[maxSize];

    public int top ;//栈顶指针 ；

    public Stack(){
        this.top = -1; // 规定 top =-1 为空栈
    }


    public boolean isEmpty(){
        if(this.top ==-1){
            return true;
        }else{
            return false;
        }
    }

    //进栈
    public int push(String x){
        if(this.top == maxSize -1){ //栈满不能进站
            throw new RuntimeException("Stack is Full");
        }
        ++ this.top;
        this.data[this.top] = x;
        return 1;
    }

    //出栈
    public String pop(){

        if(this.top == -1){
            throw new RuntimeException("Stack is Empty");
        }

        String x = this.data[this.top];
        -- this.top;
        return x;
    }



    public static void main(String[]args){
        Stack stack = new Stack();
        System.err.println("isempty:" + stack.isEmpty());

        for(int i =0 ; i <= 5 ;i++){
            stack.push(i+"");
        }

        for(int i =0 ; i <= 10 ;i++){
            String x = stack.pop();
            System.err.println("x=" + x);
        }


    }







}
