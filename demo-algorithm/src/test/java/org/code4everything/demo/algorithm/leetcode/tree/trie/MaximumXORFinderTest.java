package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class MaximumXORFinderTest {

    @Test
    public void test() {
        System.out.println(1 >> 2);
    }

    @Test
    public void findMaximumXOR() {
        MaximumXORFinder finder = new MaximumXORFinder();
        int[] case1 = new int[]{3, 10, 5, 25, 2, 8};
        assert violentFind(case1) == finder.findMaximumXOR(case1);
        int[] case2 = new int[]{8, 10, 2};
        assert violentFind(case2) == finder.findMaximumXOR(case2);
    }

    public int violentFind(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] ^ nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }
}
