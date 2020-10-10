package com.kyrie.datastructure.search.practice;

/**
 * Created by tend on 2020/9/22.
 * hash表
 */
public class HashTab {


    private Node<Employee>[] nodes;

    private int size;


    public HashTab(int size) {
        this.size = size;
        nodes = new Node[size];
    }


    public void add(Employee e){
        int index = getIndex(e);

        Node<Employee> node = nodes[index];

        Node<Employee> employeeNode = new Node<>(e);

        if(node == null){
            nodes[index] = employeeNode;
        }else{

            while(node.getNext() != null){

                node = node.getNext();
            }
            node.setNext(employeeNode);
        }
    }

    public boolean find(Employee e){
        int index = getIndex(e);

        boolean b = false;
        Node<Employee> node = nodes[index];

        if(node == null) return b;
        else{
            while(node !=null){
                if(node.getValue().equals(e)){
                    b=true;
                    break;
                }else{
                    node = node.getNext();
                }
            }
        }
        return b;
    }

    public void del(Employee e){
        int index = getIndex(e);

        Node<Employee> node = nodes[index];

        Node<Employee> pre=null;
        while(node !=null){
            if(node.getValue().equals(e)){
                pre.setNext(node.getNext());
                break;
            }else{
                pre = node;
                node = node.getNext();
            }
        }
    }

    private int getIndex(Employee e){

        int index = e.getId() % size;
        return index;
    }


    public static void main(String[] args) {

        HashTab hashTab = new HashTab(100);

        for (int i = 0; i <200 ; i++) {
            Employee employee = new Employee(i, "xiaoming" + i);
            hashTab.add(employee);
        }

        int i =32;
        Employee employee = new Employee(i, "xiaoming" + i);

        boolean b = hashTab.find(employee);

        hashTab.del(employee);

        boolean b2 = hashTab.find(employee);

        System.out.println("b:"+b+";b2:" + b2);
    }
}


class Node<T>{

    private T value;

    public Node(T t){
        this.value = t;
    }

    private Node<T> next;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}


class Employee{

    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return !(name != null ? !name.equals(employee.name) : employee.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


