package com.kyrie.datastructure.struct.stack;

import java.util.Iterator;

/**
 * Created by tend on 2019/9/29.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {


    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }


    public void push(Item item){



    }


    public Item pop(){
        return null;
    }













    @Override
    public Iterator<Item> iterator() {
        return null;
    }



}
