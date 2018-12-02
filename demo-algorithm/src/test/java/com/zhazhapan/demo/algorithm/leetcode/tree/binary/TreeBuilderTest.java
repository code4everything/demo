package com.zhazhapan.demo.algorithm.leetcode.tree.binary;

import org.junit.Test;

public class TreeBuilderTest {

    @Test
    public void buildTree() {
        TreeBuilder builder = new TreeBuilder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        long start = System.currentTimeMillis();
        builder.buildTree(inorder, postorder);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
