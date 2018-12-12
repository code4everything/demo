package com.zhazhapan.demo.algorithm.leetcode.tree;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;
import com.zhazhapan.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void isValidBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        assert tree.isValidBST(codec.deserialize("2,1,3"));
        assert !tree.isValidBST(codec.deserialize("5,1,(4,3,6)"));
        assert !tree.isValidBST(codec.deserialize("10,5,(15,6,20)"));
        assert tree.isValidBST(codec.deserialize("-2147483648,null,2147483647"));

    }

    @Test
    public void searchBST() {
        TreeCodec codec = new TreeCodec();
        BinarySearchTree tree = new BinarySearchTree();
        TreeNode root = codec.deserialize("4,(2,1,3),7");
        assert "(2,1,3)".equals(codec.serialize(tree.searchBST(root, 2)));
        assert "".equals(codec.serialize(tree.searchBST(root, 5)));
    }
}
