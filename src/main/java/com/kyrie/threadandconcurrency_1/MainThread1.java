package com.kyrie.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/30.
 */
public class MainThread1 {

    public static void main (String[] args){

        long id  = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int  priority = Thread.currentThread().getPriority();
        Thread.State state = Thread.currentThread().getState();

        String threadGroupName = Thread.currentThread().getThreadGroup().getName();

        System.out.println("id="+id+"; name="+name+"; priority="+priority+"; state="+state+"; threadGroupName="+threadGroupName);


    }

}
