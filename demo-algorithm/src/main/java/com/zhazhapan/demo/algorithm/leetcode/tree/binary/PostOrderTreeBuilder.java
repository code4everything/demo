package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018-12-02
 */
public class PostOrderTreeBuilder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length < 1 || postorder == null || postorder.length < 1) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);
        int i = 0;
        for (; i <= inEnd; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        node.left = buildTree(inorder, inStart, i - 1, postorder, postStart, postStart + i - inStart - 1);
        node.right = buildTree(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
        return node;
    }
}
