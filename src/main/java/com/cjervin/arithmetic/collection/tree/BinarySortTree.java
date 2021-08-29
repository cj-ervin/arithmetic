package com.cjervin.arithmetic.collection.tree;

/**
 * 二叉排序树
 *
 * @author ervin
 * @Date 2021/7/6
 */
public class BinarySortTree {

    class Node {
        public int value;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public BinarySortTree() {
        this.root = null;
        this.size = 0;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public Node findMin(Node node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node);
        }
    }

    public Node findMax(Node node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        } else {
            return findMax(node);
        }
    }

    public boolean isContains(int e) {
        Node current = root;
        if (current == null) {
            return false;
        }
        while (current != null && current.value != e) {
            if (e > current.value) {
                //向右
                current = current.right;
            } else {
                //向左
                current = current.left;
            }
        }
        if (current.value == e) {
            return true;
        }
        return false;
    }


    public Node insert(int e) {
        Node current = root;
        if (current == null) {
            root = new Node(e);
            return root;
        }
        while (current != null) {
            if (e > current.value) {
                //向右
                if (current.right == null) {
                    current.right = new Node(e);
                    return current.right;
                } else {
                    current = current.right;
                }
            } else if (e < current.value) {
                //向右
                if (current.left == null) {
                    current.left = new Node(e);
                    return current.left;
                } else {
                    current = current.left;
                }
            }
        }
        return current;
    }

    public Node remove(Node node, int e) {

        if (node == null) {
            return null;
        }
        if (e > node.value) {
            //向右查找
            remove(node.right, e);
        } else if (e < node.value) {
            //向左查找
            remove(node.left, e);
        } else if (node.left != null && node.right != null) {
            //查找到目标节点
            node.value = findMin(node.right).value;
            remove(node.right, node.value);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.right != null) {
                node = node.right;
            } else if (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

}
