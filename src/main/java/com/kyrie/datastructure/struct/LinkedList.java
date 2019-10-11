package com.kyrie.datastructure.struct;

/**
 * Created by Kyrie on 2017/7/18.
 *
 * 带头结点的单链表：除了头节点，每个节点包含一个数据域一个指针域，除了头、尾节点，每个节点的指针指向下一个节点
 */
public class LinkedList<T> {



    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data,Node<T> next){
            this.data = data;
            this.next = next;
        }

        Node(T data){
            this(data,null);
        }

    }

    //data
    public Node<T> head;

    public LinkedList(){
        head = new Node<T>(null);
    }

    public boolean isEmpty(){
        return head.next == null;
    }




    //打印链表
    public  void traverse(){
        if (isEmpty()){
            System.out.println("null");
        } else {
            for(Node<T> p = head.next; p !=null ; p = p.next)
                System.out.println(p.data);
        }
    }

    /**
     * 头插法构造链表
     * @param item
     */
    public void addFromHead(T item){
        Node<T> newNode = new Node<T>(item);
        newNode.next = head.next;
        head.next = newNode;
    }

    /**
     * 尾插法构造链表
     * @param item
     */
    public void addFromTail(T item){
        Node<T> newNode = new Node<T>(item);
        Node<T> p = head;
        while(p.next !=null) //找到p的尾部
            p = p.next;
        p.next = newNode;
        newNode.next = null;
    }

    public void removeFromHead(){
        if(!isEmpty()){
            head = head.next;
        }else System.out.println("The list have been emptied");
    }

    /**
     * 从尾部移除
     */
    public void removeFromTail(){
        Node<T> prev = null, curr = head;

        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        if(curr.next == null){
            prev.next = null;
        }
    }

    /**
     * 在指定的元素后面的插入
     * @param appointedItem
     * @param item
     * @return
     */
    public boolean insert(T appointedItem, T item){
        Node<T> prev = head, curr= head.next, newNode;

        newNode = new Node<T>(item);
        if(!isEmpty()){
            while((curr!=null) && (!appointedItem.equals(curr.data))){
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr;
            prev.next= newNode;
            return true;
        }
        return false;
    }

    public void remove(T item){
        Node<T> curr = head,prev = null;
        boolean found = false;
        while(curr !=null && !found){
            if(item.equals(curr.data)){
                if(prev == null)
                    removeFromHead();
                else
                    prev.next = curr.next;
                found =true;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public int indexOf(T item){
        int index = 0;
        Node<T> p;
        for(p = head.next; p!=null; p = p.next){ //遍历链表
            if(item.equals(p.data))
                return index;
            index ++;
        }
        return -1;
    }

    public boolean contains(T item){
        return indexOf(item) != -1;
    }


   public static LinkedList<Integer> merge(Node<Integer> A,Node<Integer> B){

       Node<Integer> p = A.next;

       Node<Integer> q = B.next;

       Node<Integer> r;

       Node<Integer> C;
       C = A;
       C.next = null;

       r=C; //此时r和C指向同一个结点
       while (p !=null && q!=null){

           if(p.data <= q.data){
               r.next =p;p=p.next;
               r=r.next;
           }else{
               r.next= q; q=q.next;
               r =r.next;
           }

       }
       r.next = null;

       if(p!=null) r.next = p;
       if(q !=null) r.next =q;

       LinkedList CList = new LinkedList<Integer>();
       CList.head = C;
       return CList;

   }

}
