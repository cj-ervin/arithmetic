package com.cjervin.arithmetic.arithmetic.list;

/**
 * 合并链表
 *
 * @author ervin
 * @Date 2022/3/10
 */
public class MergeLists extends SimpleLinkedList{


    /**
     * 合并两个链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-cha-loaq/
     *
     * @param l1 链表 1 header
     * @param l2 链表 2 header
     * @return 合并后的链表
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(-1, null), p = head;
        Node p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.item <  p2.item) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        Node x1 = new Node(30, null);
        Node x2 = new Node(11, x1);
        Node x3 = new Node(10, x2);
        Node x4 = new Node(6, x3);
        Node x5 = new Node(1, x4);

        Node y1 = new Node(61, null);
        Node y2 = new Node(60, y1);
        Node y3 = new Node(3, y2);
        Node y4 = new Node(2, y3);
        Node y5 = new Node(0, y4);

        Node node = mergeTwoLists(x5, y5);
        System.out.println("====");
    }


}
