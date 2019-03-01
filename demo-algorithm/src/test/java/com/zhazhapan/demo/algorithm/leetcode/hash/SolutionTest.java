package com.zhazhapan.demo.algorithm.leetcode.hash;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isHappy() {
        assert !solution.isHappy(2);
        assert solution.isHappy(996655423);
        assert solution.isHappy(19);
    }

    @Test
    public void isIsomorphic() {
        assert solution.isIsomorphic("add", "egg");
        assert !solution.isIsomorphic("foo", "bar");
        assert solution.isIsomorphic("paper", "title");
        assert !solution.isIsomorphic("ab", "aa");
    }
}