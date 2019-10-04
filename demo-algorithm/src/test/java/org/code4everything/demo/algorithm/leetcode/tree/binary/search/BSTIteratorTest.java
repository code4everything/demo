package org.code4everything.demo.algorithm.leetcode.tree.binary.search;

import org.code4everything.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class BSTIteratorTest {

    @Test
    public void testIterator() {
        TreeCodec codec = new TreeCodec();
        BSTIterator iterator = new BSTIterator(codec.deserialize("6,(5,(1,null,(3,2,4))),(8,7,9)"));
        int[] assertResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int i = 0;
        while (iterator.hasNext()) {
            assert assertResult[i++] == iterator.next();
        }
    }
}
