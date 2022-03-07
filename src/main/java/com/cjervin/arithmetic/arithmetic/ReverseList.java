package com.cjervin.arithmetic.arithmetic;


/**
 * 链表反转 两种方法 1：遍历 2：递归
 *
 * @author ervin
 * @Date 2022/3/7
 */
public class ReverseList {


    private static class Node<T> {
        T item;
        Node next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }


    /**
     * 遍历方式
     * @param node
     * @return
     */
    public static Node iterate(Node node) {
        Node pre = null;
        Node next;
        Node current = node;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);

        Node iterate = iterate(node5);
        System.out.println("=====");
    }
}
