package org.code4everything.demo.algorithm.leetcode.tree.binary;

import org.junit.Test;

public class PostOrderTreeBuilderTest {

    @Test
    public void buildTree() {
        PostOrderTreeBuilder builder = new PostOrderTreeBuilder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        long start = System.currentTimeMillis();
        builder.buildTree(inorder, postorder);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
