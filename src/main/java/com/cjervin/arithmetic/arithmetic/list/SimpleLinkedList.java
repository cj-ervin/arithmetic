package com.cjervin.arithmetic.arithmetic.list;


/**
 * @author ervin
 * @Date 2022/3/10
 */
public class SimpleLinkedList {

    protected static class Node {
        int item;
        Node next;

        Node(int element, Node next) {
            this.item = element;
            this.next = next;
        }
    }

    Node header;

    private int size;
}
