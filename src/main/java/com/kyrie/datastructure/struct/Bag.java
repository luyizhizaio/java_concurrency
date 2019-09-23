package com.kyrie.datastructure.struct;

import com.kyrie.datastructure.utils.StdIn;
import com.kyrie.datastructure.utils.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tend on 2019/9/20.
 * Bag 使用链式存储，不支持删除元素的集合数据类型。处理元素顺序不重要
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;

    private int n; //bag中元素的数量

    //链表
    private static class Node<Item>{
        private Item item;
        private Node<Item> next;
    }

    public Bag(){
        first = null;
        n=0;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void add(Item item){
        //头插法
        Node<Item> oldFirst =first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public int size(){
        return n;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }


    private class ListIterator implements Iterator<Item>{
        private Node<Item> current;

        public ListIterator(Node<Item> first){
            current = first;
        }


        @Override
        public boolean hasNext() {
            return current !=null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {

        Bag<String> bag = new Bag<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            bag.add(item);
        }
        StdOut.println("size of bag:"+ bag.size());
        for (String s : bag){
            StdOut.println(s);
        }
    }
}
