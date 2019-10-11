package com.kyrie.datastructure.struct.stack;

import java.util.Iterator;

/**
 * Created by tend on 2019/10/10.
 * 使用链表实现栈，表头为栈顶。
 */
public class StackByLinkedList<Item> implements Iterable<Item>  {

    private Node first;
    private int N;

    private class Node{
        private Item item;
        private Node next;
        public Node(Item item){
            this.item = item;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return N;
    }

    public void push(Item item){

        if(isEmpty()) first = new Node(item);
        else {
            Node node = new Node(item);
            node.next = first;
            first = node;
        }
        N++;
    }

    public Item pop(){

        if(!isEmpty()) {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }else{
            throw new RuntimeException("Stack is empty");
        }

    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements  Iterator<Item>{
        private Node node = first;
        @Override
        public boolean hasNext() {
            return  node !=null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }


    public static void main(String[] args) {

        StackByLinkedList<String> stack = new StackByLinkedList<String>();
        stack.push("HELLO");
        stack.push("WORLD");
        System.out.println("size:"+stack.size());
        System.out.println("isEmpty:" + stack.isEmpty());

        for(String str: stack){
            System.out.println("str:" +str);
        }


    }



}
