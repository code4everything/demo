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
        TreeNode node = root;
        // 找到要删除的节点
        while (node != null) {
            if (node.val == key) {
                return deleteNode(null, node, true);
            } else if (node.val > key) {
                if (node.left != null && node.left.val == key) {
                    deleteNode(node, node.left, true);
                    break;
                }
                node = node.left;
            } else {
                if (node.right != null && node.right.val == key) {
                    deleteNode(node, node.right, false);
                    break;
                }
                node = node.right;
            }
        }
        return root;
    }

    /**
     * 判断节点的子节点个数
     */
    private TreeNode deleteNode(TreeNode parentNode, TreeNode node, boolean isLeft) {
        boolean isLeftNull = node.left == null;
        boolean isRightNull = node.right == null;
        if (isLeftNull && isRightNull) {
            return deleteNode(parentNode, isLeft, null);
        } else if (isRightNull) {
            return deleteNode(parentNode, isLeft, node.left);
        } else if (isLeftNull) {
            return deleteNode(parentNode, isLeft, node.right);
        } else {
            // 最后一个右子节点的父节点
            TreeNode x = node.left;
            // 找到最大的子节点
            while (x.right != null) {
                if (x.right.right == null) {
                    break;
                }
                x = x.right;
            }
            // 最后一个右子节点
            TreeNode y = x.right;
            TreeNode z;
            if (y == null) {
                z = deleteNode(parentNode, isLeft, x);
            } else {
                x.right = y.left;
                z = deleteNode(parentNode, isLeft, y);
                z.left = node.left;
            }
            z.right = node.right;
            return z;
        }
    }

    /**
     * 删除子节点小于等于一个的节点
     */
    private TreeNode deleteNode(TreeNode parentNode, boolean isLeft, TreeNode childNode) {
        if (parentNode == null) {
            return childNode;
        }
        if (isLeft) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
        return childNode;
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
