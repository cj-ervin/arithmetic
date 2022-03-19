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
}
