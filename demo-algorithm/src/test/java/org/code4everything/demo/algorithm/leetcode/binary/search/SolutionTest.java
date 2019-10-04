package org.code4everything.demo.algorithm.leetcode.binary.search;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void superEggDrop() {
        assert 9 == solution.superEggDrop(1, 9);
        assert 2 == solution.superEggDrop(1, 2);
        assert 3 == solution.superEggDrop(3, 6);
        assert 4 == solution.superEggDrop(4, 14);
        assert 3 == solution.superEggDrop(2, 6);
    }
}
