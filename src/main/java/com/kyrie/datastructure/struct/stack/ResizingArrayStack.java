package com.kyrie.datastructure.struct.stack;

import java.util.Iterator;

/**
 * Created by tend on 2019/9/29.
 *
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {


    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public void resize(int max){

        Item [] temp = (Item[])new Object[max];
        for (int i = 0; i <a.length ; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N == a.length) resize(2 * a.length);
        a[N++] = item;

    }


    public Item pop(){
        Item item  =a[--N];
        a[N] =null;

        if(N >0 && N == a.length/4)resize(a.length / 2);
        return  item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private int i = N;

    private class ReverseArrayIterator implements  Iterator<Item>{

        @Override
        public boolean hasNext() {
            return  i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {

    }


}
