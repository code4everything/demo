package com.zhazhapan.demo.algorithm.leetcode.tree;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-10
 */
public class BinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode childNode = new TreeNode(val);
        if (root == null) {
            return childNode;
        }
        TreeNode node = root;
        while (true) {
            if (node.val == val) {
                break;
            } else if (node.val > val) {
                if (node.left == null) {
                    node.left = childNode;
                    break;
                } else {
                    node = node.left;
                }
            } else if (node.right == null) {
                node.right = childNode;
                break;
            } else {
                node = node.right;
            }
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

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
