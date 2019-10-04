package org.code4everything.demo.algorithm.leetcode.contest.c144;

import org.code4everything.demo.algorithm.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/7/7
 */
public class Contest5119 {

    private List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] delete) {
        int[] deletes = new int[1001];
        for (int i : delete) {
            deletes[i] = 1;
        }
        delHelper(root, deletes, true);
        return list;
    }

    private boolean delHelper(TreeNode node, int[] delete, boolean parentDelete) {
        if (node == null) {
            return true;
        }
        if (delete[node.val] == 1) {
            delHelper(node.left, delete, true);
            delHelper(node.right, delete, true);
            return true;
        }
        if (parentDelete) {
            list.add(node);
        }
        boolean leftDelete = delHelper(node.left, delete, false);
        boolean rightDelete = delHelper(node.right, delete, false);
        if (leftDelete) {
            node.left = null;
        }
        if (rightDelete) {
            node.right = null;
        }
        return false;
    }
}
