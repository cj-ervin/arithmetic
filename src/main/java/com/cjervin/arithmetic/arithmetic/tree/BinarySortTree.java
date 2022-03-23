package com.cjervin.arithmetic.arithmetic.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 二叉树的最小深度
     * <p>
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/er-cha-shu-zui-duan-lu-jing-by-changxiao-ygl6/
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    //说明此时已经走到了终点
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
