package com.zhazhapan.demo.algorithm.leetcode.tree;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-10
 */
public class BinarySearchTree {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            boolean isLeftNull = root.left == null;
            boolean isRightNull = root.right == null;
            if (isLeftNull && isRightNull) {
                return null;
            } else if (isRightNull) {
                return root.left;
            } else if (isLeftNull) {
                return root.right;
            } else {
                if (root.left.right == null) {
                    root.left.right = root.right;
                    return root.left;
                }
                // 最后一个右子节点的父节点
                TreeNode pre = root.left;
                while (pre.right.right != null) {
                    pre = pre.right;
                }
                // 最后一个右子节点
                TreeNode current = pre.right;
                pre.right = current.left;
                current.left = root.left;
                current.right = root.right;
                return current;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

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