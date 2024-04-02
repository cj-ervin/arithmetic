package com.cjervin.arithmetic.arithmetic.list;

import java.util.PriorityQueue;

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
     * 单列表的分解
     * https://leetcode.cn/problems/partition-list/
     * <p>
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
     * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * <p>
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *
     * @param head head
     * @param x flag
     * @return 合并的链表
     */
    public static Node partition(Node head, int x) {
        Node p = head;
        Node l1 = new Node(-1, null);
        Node l2 = new Node(-1, null);
        Node p1 = l1, p2 = l2;
        while (p != null) {
            if (p.item < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1.next != null) {
            p1.next = null;
        }
        if (p2.next != null) {
            p2.next = null;
        }

        p1.next = l2.next;
        return l1.next;
    }

    /**
     * 合并 k 个有序链表
     * <p>
     * https://leetcode.cn/problems/merge-k-sorted-lists/description/
     * <p>
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * @param lists
     * @return
     */
    public Node mergeKLists(Node[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //虚拟头结点
        Node dummy = new Node(-1, null);
        Node p = dummy;
        //优先级队列，最小堆
        PriorityQueue<Node> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.item - b.item));
        for (Node head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            Node pn = pq.poll();
            p.next = pn;
            if (pn.next != null) {
                pn = pn.next;
                pq.add(pn);
            }
            p = p.next;
        }
        return dummy.next;
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


    /**
     * 如果链表中含有环，如何计算这个环的起点？
     * <p>
     * 利用快慢指针：快指针（f）步长 2，慢指针(s)指针步长 1，当两个指针相遇时，假设 s 走过的长度为 k, f 走过的长度为 2k，
     * 此时 k 为环长度的整数倍（s 走过的长度为 k，落在了环上的某一个节点 M ； f 走过的长度为 2k, 相当于先走了一个 k 的长度，
     * 落到 M 上，然后又走了一个 k 的长度，绕环一圈或几圈，又走到了 M 上 ）。设头节点 X，环起点 Y，相遇点 Z, 假设环起点 Y 与
     * 相遇点 Z 距离为 d ,此时头节点 X 与环起点 Y 距离为 k-d, 而且从相遇点 Z 再走 k-d 步也能到达环起点 Y。
     * <p>
     * 所以，当快慢指针相遇时，将快指针（f）、慢指针(s)任意一个指向头节点 X，然后两个指针同速前进，相遇之处就是环的起点了。
     * <p>
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-by-changxiaojie-t407/
     *
     * @param head 头节点
     * @return 环起点
     */
    public static Node detectCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //相遇
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            // fast 遇到空指针说明没有环
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }


    /**
     * 链表相交
     * 利用双指针实现，问题的关键是让两个指针同时走到相交的节点，由于两个链表长度不确定
     * 我们让 x 指针先走完链表 A，再走链表 B， y 指针先走完链表 B，再走链表 A，
     * 这样两个指针到达相交节点的长度是一样的。
     * <p>
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/by-changxiaojie-9ija/
     *
     * @param headA 链表 A
     * @param headB 链表 B
     * @return 相交节点
     */
    public static Node getIntersectionNode(Node headA, Node headB) {
        Node x = headA, y = headB;

        boolean flagX = true;
        boolean flagY = true;
        while (x != null && x != y) {
            x = x.next;
            y = y.next;
            if (x == null && flagX) {
                flagX = false;
                x = headB;
            }
            if (y == null && flagY) {
                flagY = false;
                y = headA;
            }
        }
        if (x == y) {
            return x;
        }
        return null;
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
