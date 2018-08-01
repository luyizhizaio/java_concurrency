package com.kyrie.threadandconcurrency_1;

/**
 * Created by tend on 2018/7/31.
 * Most often you will have to synchronize access to some resource that only exists once per JVM.
 * The common means to do that is to use static member variable of a class:
 */
public class StaticSync {

    private static Integer sync = 0 ;
    public void someMethod (){

        synchronized (sync){
            // synchronized on ClassLoader/JVM level

        }
    }


}
