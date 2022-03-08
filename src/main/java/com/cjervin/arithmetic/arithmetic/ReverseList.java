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
     * @param head 头节点
     * @return result
     */
    private static Node iterate(Node head) {
        Node pre = null;
        Node next;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    /**
     * 递归实现
     * @param head 头节点
     * @return result
     */
    private static Node recursion(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node newNode =  recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);

        Node node = recursion(node5);

        System.out.println("=====");
        Node head = iterate(node5);
    }
}
