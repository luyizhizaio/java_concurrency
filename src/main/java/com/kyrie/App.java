package com.kyrie;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );

        Map<Thread,StackTraceElement[]> m = Thread.getAllStackTraces();

        for(Map.Entry<Thread,StackTraceElement[]> en :m.entrySet()){

            Thread t = en.getKey();
            StackTraceElement[] v = en.getValue();
            for(StackTraceElement s :v){
                System.err.println(s.toString());
            }

        }
    }
}
