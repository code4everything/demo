package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;
import org.junit.Test;

public class TreeCodecTest {

    @Test
    public void serialize() {
    }

    @Test
    public void deserialize() {
        long start = System.currentTimeMillis();
        TreeCodec codec = new TreeCodec();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        String result = codec.serialize(root);
        System.out.println(result);
        TreeNode node = codec.deserialize(result);
        assert result.equals(codec.serialize(node));
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        result = codec.serialize(root);
        System.out.println(result);
        node = codec.deserialize(result);
        assert result.equals(codec.serialize(node));
        System.out.println(System.currentTimeMillis() - start);
    }
}
