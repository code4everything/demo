package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

/**
 * @author pantao
 * @since 2018/12/3
 **/
public class PreOrderTreeBuilder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        int i = 0;
        for (; i <= inEnd; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        node.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
        node.right = buildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
        return node;
    }
}
