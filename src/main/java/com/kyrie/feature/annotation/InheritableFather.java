package com.kyrie.feature.annotation;

/**
 * Created by tend on 2020/9/22.
 */
@Inheritable
public class InheritableFather {

    public InheritableFather(){
        System.out.println(""+InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args) {
        InheritableSon inheritableSon = new InheritableSon();

    }
}

class InheritableSon extends InheritableFather {

    public InheritableSon(){
        System.out.println(""+InheritableSon.class.isAnnotationPresent(Inheritable.class));
    }
}