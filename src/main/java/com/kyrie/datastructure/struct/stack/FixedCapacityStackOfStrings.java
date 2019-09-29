package com.kyrie.datastructure.struct.stack;

import com.kyrie.datastructure.utils.StdIn;
import com.kyrie.datastructure.utils.StdOut;

import java.util.Iterator;

/**
 * Created by tend on 2019/9/29.
 * 使用数组实现栈
 */
public class FixedCapacityStackOfStrings implements Iterable<String> {

    private String a[];

    private int N; //栈中元素

    public FixedCapacityStackOfStrings(int capacity){

        a= new String[capacity];

    }


    public void push(String element){
        a[N++] =element;
    }


    public String pop(){
        return a[--N];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }


    @Override
    public Iterator iterator() {
        return new FixedCapacityStackOfStringsIterator();
    }

    private class FixedCapacityStackOfStringsIterator implements Iterator<String>{

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public String next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {

        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);

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
