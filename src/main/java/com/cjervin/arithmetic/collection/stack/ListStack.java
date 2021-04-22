package com.cjervin.arithmetic.collection.stack;

/**
 * 栈 链表实现
 *
 * @author ervin
 * @Date 2021/4/20
 */
public class ListStack<T> {

    private static class Node<T> {
        T item;
        Node next;

        Node(T ele, Node next) {
            this.item = ele;
            this.next = next;
        }
    }

    private Node header;
    private int size;

    ListStack() {
        this.header = new Node(null, null);
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(T data) {
        Node n = null;
        if (header.next != null) {
            n = new Node(data, header.next);
        } else {
            n = new Node(data, null);
        }
        this.header.next = n;
        size++;
    }

    public T pop() throws Exception {
        if (this.header.next == null) {
            throw new Exception("stack empty");
        }
        Node n = this.header.next;
        if (n.next != null) {
            this.header.next = n.next;
        } else {
            this.header.next = null;
        }
        size--;
        return (T) n.item;
    }

    public static void main(String[] args) throws Exception {
        ListStack<String> stack = new ListStack<>();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        stack.push("dd");
        stack.push("ee");
        System.out.println("stack size: " + stack.size());
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            System.out.println("stack pop: " + stack.pop());
        }
//        stack.pop();
    }
}
