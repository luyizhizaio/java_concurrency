package com.kyrie.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tend on 2019/2/24.
 */
public class JConsoleTest {

    public byte[] bytes = new byte[128 * 1024];

    public static void main (String [] args){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start ....");

        fill(1000);


    }

    public static void fill(int n){

        List list = new ArrayList();
        for (int i = 0; i <n ; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.add(new JConsoleTest());
        }

    }

}
