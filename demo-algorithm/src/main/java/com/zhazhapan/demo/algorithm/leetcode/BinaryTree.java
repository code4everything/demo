package com.zhazhapan.demo.algorithm.leetcode;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2018/9/25
 **/
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(9);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        // 前序遍历
        List<Integer> preOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(9, 8, 7));}};
        Assert.assertEquals(preOrder, binaryTree.preOrderTraversal(root));
        // 中序遍历
        List<Integer> inOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(8, 9, 7));}};
        Assert.assertEquals(inOrder, binaryTree.inOrderTraversal(root));
        // 后序遍历
        List<Integer> postOrder = new ArrayList<Integer>(8) {{addAll(Arrays.asList(8, 7, 9));}};
        Assert.assertEquals(postOrder, binaryTree.postOrderTraversal(root));
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(postOrderTraversal(root.left));
            }
            if (root.right != null) {
                list.addAll(postOrderTraversal(root.right));
            }
            list.add(root.val);
        }
        return list;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            if (root.left != null) {
                list.addAll(inOrderTraversal(root.left));
            }
            list.add(root.val);
            if (root.right != null) {
                list.addAll(inOrderTraversal(root.right));
            }
        }
        return list;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                list.addAll(preOrderTraversal(root.left));
            }
            if (root.right != null) {
                list.addAll(preOrderTraversal(root.right));
            }
        }
        return list;
    }
}
