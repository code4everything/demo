package org.code4everything.demo.algorithm.leetcode.tree.binary.search;

import org.code4everything.demo.algorithm.leetcode.model.TreeNode;
import org.code4everything.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class CommonAncestorTest {

    @Test
    public void lowestCommonAncestor() {
        TreeCodec codec = new TreeCodec();
        CommonAncestor commonAncestor = new CommonAncestor();
        TreeNode root = codec.deserialize("6,(2,0,(4,3,5)),(8,7,9)");
        assert root == commonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        assert root.left == commonAncestor.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
    }
}
