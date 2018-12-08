package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;
import org.junit.Test;

public class CommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        CommonAncestor ancestor = new CommonAncestor();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        assert root.val == ancestor.lowestCommonAncestor(root, root.left, root.right).val;
        assert root.left.val == ancestor.lowestCommonAncestor(root, root.left, root.left.right.right).val;
    }
}
