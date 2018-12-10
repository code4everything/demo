package com.zhazhapan.demo.algorithm.leetcode.tree;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-10
 */
public class BinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        boolean res = true;
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            res = root.val > root.left.val && root.left.val > min;
        }
        if (res && root.right != null) {
            res = root.right.val > root.val && root.right.val < max;
        }
        return res && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
