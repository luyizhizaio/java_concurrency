package com.kyrie.datastructure.struct;

/**
 * Created by Kyrie on 2019/1/30.
 */
public class MainTest {

    public static void main(String[] args){

        LinkedList<Integer> A = new LinkedList<Integer>();


        A.addFromHead(7);
        A.addFromHead(6);
        A.addFromHead(4);
        A.addFromHead(2);


        A.traverse();
        System.out.println("index=" + A.indexOf(5));



        LinkedList<Integer> B = new LinkedList<Integer>();


        B.addFromHead(5);
        B.addFromHead(4);
        B.addFromHead(3);
        B.addFromHead(1);

        LinkedList CList = LinkedList.merge(A.head,B.head);

        System.out.println("-----------------------------");
        CList.traverse();
    }
}
