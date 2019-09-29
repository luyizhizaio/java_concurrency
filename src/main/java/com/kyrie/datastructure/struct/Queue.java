package com.kyrie.datastructure.struct;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 顺序循环队列（循环队列防止假溢出）
 * Created by Kyrie on 2017/7/20.
 * 队列先进先出 （FIFO）
 */
public class Queue<T> implements Iterable<T> {

    private int DEFAULT_SIZE = 10;

    private int capacity;

    private T[] data; //数组保存元素

    private int front = 0;

    private int rear = 0;

    public Queue(){

        capacity = DEFAULT_SIZE;
        data = (T[])new Object[capacity];
    }

    public Queue(T element){
        this();
        ++ rear;
        data[rear] = element;
    }

    public Queue(T element , int initSize){

        this.capacity = initSize;
        data =(T[]) new Object[capacity]; //不能创建泛型数组。创建Object数组强转成泛型数组。
        ++ rear;
        data[rear] = element;
    }

    public boolean empty(){
        return front == rear;
    }

    public int size(){
        return rear - front;
    }


    //向数组里增加元素
    public int enQueue(T element){
        if((rear +1) % capacity == front){
            //队列满了
            return 0;
        }

        rear = (rear +1)%capacity;
        data[rear] =element;
        System.out.println("enter queue:"+ element);
        return 1;
    }

    public T deQueue(){
        if(empty()){
            throw new IndexOutOfBoundsException("queue is empty");
        }
        front = (front +1) % capacity;
        T oldValue = (T) data[front]; //移除前面的元素
        data[front] = null;
        System.out.println("enter queue:"+ oldValue);
        return oldValue;
    }

    public T element(){
        if(empty()){
            throw new IndexOutOfBoundsException("queue is empty");
        }
        return (T) data[front];
    }

    public void clear(){
        Arrays.fill(data, null);
        front = 0;
        rear = 0;
    }

    public String toString(){
        if(empty()){
            return "[]";
        }else{
            StringBuilder sb= new StringBuilder("[");
            for(int i =front+1; i<= rear;i++){
                sb.append(data[i].toString()+ ",");
            }
            int len = sb.length();
            return sb.delete(len-1,len).append("]").toString();
        }
    }

    public static void main(String[] args){
        Queue<String> queue = new Queue<String>("ABC",20);
        queue.enQueue("xxx");
        System.out.println(queue.toString());
        System.out.println(queue.size());
        System.out.println(queue.deQueue());
        System.out.println(queue.toString());
        queue.clear();
        System.out.println(queue.empty());

        for(int i = 0 ; i <100 ; i++){

            queue.enQueue("xxx"+i);
            queue.deQueue();
        }

    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
