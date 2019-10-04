package org.code4everything.demo.algorithm.leetcode.tree.binary;

import org.junit.Test;

public class PreOrderTreeBuilderTest {

    @Test
    public void buildTree() {
        PostOrderTreeBuilder builder = new PostOrderTreeBuilder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        System.out.println(builder.buildTree(preorder, inorder));
        preorder = new int[]{3, 9, 6, 7};
        inorder = new int[]{6, 9, 7, 3};
        System.out.println(builder.buildTree(preorder, inorder));
    }
}
