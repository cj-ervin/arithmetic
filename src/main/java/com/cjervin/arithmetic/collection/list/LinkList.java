package com.cjervin.arithmetic.collection.list;

/**
 * 链表实现
 *
 * @author ervin
 * @Date 2021/4/18
 */
public class LinkList<T> implements ListInterface<T> {


    private static class Node<T> {
        T item;
        Node next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }

    Node header;

    private int size;

    public LinkList() {
        this.header = new Node(null, null);
        this.size = 0;
    }

    @Override
    public void init(int size) {
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    @Override
    public int eleIndex(T t) {
        Node n = header.next;
        int index = 0;
        while (n.next != null) {
            if (n.item.equals(t)) {
                return index;
            }
            index++;
            n = n.next;
        }
        //找不到返回-1
        return -1;
    }

    @Override
    public T getEle(int index) throws Exception {
        Node n = getNode(index);
        return (T) n.item;
    }

    @Override
    public void add(int index, T t) throws Exception {
        //考虑第一个元素
        if (index == 0) {
            this.header.next = new Node(t, null);
        } else {
            Node n = getNode(index - 1);
            //获取到index的上一个元素n, n指向新建的元素，同时新建的元素指向n的下一个元素
            n.next = new Node(t, n.next);
        }
        this.size++;
    }

    @Override
    public void delete(int index) throws Exception {
        //index为0时，不用去获取上一个元素，
        if (index == 0) {
            this.header.next = getNode(1);
        } else {
            Node n = getNode(index - 1);
            n.next = n.next.next;
        }
        size--;
    }

    @Override
    public void add(T t) throws Exception {
        add(size, t);
    }

    @Override
    public void set(int index, T t) throws Exception {
        Node node = getNode(index);
        node.item = t;
    }

    private Node getNode(int index) throws Exception {
        if (index < 0 || index > this.size - 1) {
            throw new Exception("数组越界");
        }
        Node n = header.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }


    public static void main(String[] args) throws Exception {
        ListInterface<Integer> list = new LinkList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("list size === " + list.length());

        list.set(3, 22);

        System.out.println("list size === " + list.length());

        int index = list.eleIndex(22);

        System.out.println("index == " + index);

        list.delete(0);
        list.delete(3);

        int i = 6;
        System.out.println(6 >> 1);
        System.out.println(2 >> 1);
        System.out.println(-6 >> 1);
        System.out.println(5 >> 1);
        System.out.println(10 >> 1);
        System.out.println(100 >> 1);

    }
}
