package com.kyrie.datastructure.struct.stack;

import com.kyrie.datastructure.utils.StdIn;
import com.kyrie.datastructure.utils.StdOut;

/**
 * Created by tend on 2019/9/29.
 * 使用数组实现栈
 */
public class FixedCapacityStack<Item> {

    private Item a[];

    private int N; //栈中元素

    public FixedCapacityStack(int capacity){
        a= (Item[])new Object[capacity];
    }

    private void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for(int i =0 ;i<N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }


    public void push(Item element){
        //扩容
        if (N == a.length) resize(2* a.length);

        a[N++] =element;
    }


    public Item pop(){
        Item item = a[--N];
        a[N] =null;
        if(N >0 && N== a.length/4) resize(a.length / 2);
        return a[--N];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public static void main(String[] args) {

        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                s.push(item);
            }else if(!s.isEmpty()){
                System.out.println(s.pop() + " ");
            }

        }
        StdOut.println();


    }


}
