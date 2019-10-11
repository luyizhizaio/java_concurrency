package com.kyrie.datastructure.struct.linkedlist;

import java.util.Iterator;

/**
 * Created by tend on 2019/10/11.
 * 链表实现队列：first指向队列开头，last指向队列结尾
 */
public class Queue<Item> implements Iterable<Item>  {

    private Node first;//指向队列开头,也指向链表表头
    private Node last;//
    private int N;

    private class Node{

        Item item;
        Node next;

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


    public void enqueue(Item item){

        if(isEmpty()){
            first = new Node(item);
            last = first;
        }else{
            Node node = new Node(item);
            last.next = node;
            last = node;
        }
        N++;
    }


    public Item dequeue(){

        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements  Iterator<Item>{

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node !=null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;

            return item;
        }
    }

    public static void main(String[] args) {

        Queue<String> queue = new Queue<String>();
        queue.enqueue("HELLO");
        queue.enqueue("WORLD");
        queue.enqueue("WORLD2");
        System.out.println("size:" + queue.size());
        System.out.println("isEmpty:" + queue.isEmpty());

        for (String str : queue) {
            System.out.println("str:" + str);
        }


        for (String str : queue) {
            System.out.println("str:" + str);
        }

        System.out.println(queue.dequeue());


        for (String str : queue) {
            System.out.println("str:" + str);
        }


    }

}
