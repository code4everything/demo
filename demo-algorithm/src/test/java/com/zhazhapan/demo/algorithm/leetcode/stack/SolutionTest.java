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

    @Test
    public void evalRPN() {
        assert solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}) == 9;
        assert solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}) == 22;
        assert solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}) == 6;
    }

    @Test
    public void cloneGraph() {
    }

    @Test
    public void findTargetSumWays() {
        assert solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5;
        assert solution.findTargetSumWays(new int[]{1, 0}, 1) == 2;
        assert solution.findTargetSumWays(new int[]{25, 18, 47, 13, 45, 29, 15, 45, 33, 19, 39, 15, 39, 45, 17, 21,
                29, 43, 50, 10}, 25) == 5392;
    }

    @Test
    public void floodFill() {
        Console.log(solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2));
    }
}
