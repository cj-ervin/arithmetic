package com.cjervin.arithmetic.arithmetic.list;

/**
 * 链表的一些算法题
 *
 * @author ervin
 * @Date 2022/3/10
 */
public class LinkListAlgorithm extends SimpleLinkedList {


    /**
     * 合并两个链表
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     *
     * @param l1 链表 1 header
     * @param l2 链表 2 header
     * @return 合并后的链表
     */
    public static Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(-1, null), p = head;
        Node p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.item < p2.item) {
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

    /**
     * 查找链表倒数第 k 个节点
     * <p>
     * 维护两个指针，第一个指针先走 k 步，然后两个指针以同样的步长向后移动，
     * 当第一个指针移动到最后一个节点时，取出第二个指针对应的节点即可。
     * <p>
     * 相似的题目，删除列表倒数第 N 个节点
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shuang-zhi-zhen-shan-chu-lian-biao-dao-s-epjz/
     *
     * @param head 头节点
     * @param k    k
     * @return 目标节点
     */
    public static Node findFromEnd(Node head, int k) {
        Node r = head, l = head;
        for (int i = 0; i < k; i++) {
            r = r.next;
        }
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        return l;
    }

    /**
     * 判断链表中是否有环
     * <p>
     * 利用快慢指针，快指针步长 2，慢指针指针步长 1，如果快指针走到最后为 null，说明不存在指针，如果款满指针相遇，说明
     * 快指针比慢指针多走了一圈，此时有环。
     * <p>
     * https://leetcode-cn.com/problems/linked-list-cycle/solution/pan-duan-lian-biao-zhong-shi-fou-you-hua-s9j0/
     *
     * @param head head头节点
     * @return 是否有环
     */
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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


        Node node1 = mergeTwoLists(x5, y5);
        System.out.println("====");

        Node node2 = findFromEnd(node1, 3);
        System.out.println("====");
    }


}
