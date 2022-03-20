package com.cjervin.arithmetic.arithmetic.tree;

/**
 * @author ervin
 * @Date 2022/3/20
 */
public class BinarySortTree {


    private TreeNode root;
    private int size;

    public BinarySortTree() {
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
     * 验证二叉搜索树
     * <p>
     * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/ya-by-changxiaojie-yl01/
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return doCheck(root, null, null);
    }

    /**
     * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
     */
    private boolean doCheck(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return doCheck(root.left, min, root) && doCheck(root.right, root, max);
    }
}
