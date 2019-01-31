package com.zhazhapan.demo.algorithm.leetcode.stack;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isValid() {
        assert solution.isValid("()");
        assert solution.isValid("()[]{}");
        assert !solution.isValid("(]");
        assert !solution.isValid("([)]");
        assert solution.isValid("{[]}");
        assert !solution.isValid("[])");
        assert !solution.isValid("[");
    }
}
