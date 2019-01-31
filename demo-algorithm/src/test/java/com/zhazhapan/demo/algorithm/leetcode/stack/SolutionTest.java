package com.zhazhapan.demo.algorithm.leetcode.stack;

import cn.hutool.core.lang.Console;
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

    @Test
    public void dailyTemperatures() {
        Console.log(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Console.log(solution.dailyTemperatures(new int[]{100, 56, 89, 99, 45, 65, 77}));
    }
}
