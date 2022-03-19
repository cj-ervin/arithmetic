package com.cjervin.arithmetic.arithmetic.tree;

/**
 * 二叉树一些算法
 *
 * @author ervin
 * @Date 2022/3/19
 */
public class BinaryTree {

    private TreeNode root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 翻转二叉树
     * 当前是前序遍历，后序遍历也可以
     * <p>
     * https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-changxiaojie-mkk9/
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     * <p>
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/di-gui-lian-jie-by-changxiaojie-exy2/
     *
     * @param root
     * @return
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectChildren(root.left, root.right);
        return root;
    }

    private void connectChildren(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        //连接left的两个子节点
        connectChildren(left.left, left.right);
        //连接right的两个子节点
        connectChildren(right.left, right.right);
        //连接left.right, right.left
        connectChildren(left.right, right.left);
    }
}
