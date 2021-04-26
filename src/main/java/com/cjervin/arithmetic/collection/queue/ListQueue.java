package com.cjervin.arithmetic.collection.queue;

/**
 * 基于链表实现的队列
 *
 * @author ervin
 * @Date 2021/4/23
 */
public class ListQueue<T> {

    public class Node<T> {
        T item;
        Node next;

        Node(T ele, Node next) {
            this.item = ele;
            this.next = next;
        }
    }

    private Node header;

    private int size;

    ListQueue() {
        this.header = new Node(null, null);
        this.size = 0;
    }

    public void push(T data) {
        Node node = this.header.next;
        if (node == null) {
            this.header.next = new Node(data, null);
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data, null);
        }
        size++;
    }

    public T pop() {
        Node node = this.header.next;
        if (node != null) {
            size--;
            if (node.next != null) {
                this.header.next = node.next;
            } else {
                this.header.next = null;
            }
            return (T) node.item;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        ListQueue<String> queue = new ListQueue();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        queue.push("e");

        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }

}
