package com.zhazhapan.demo.algorithm.leetcode.string;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        assert solution.isPalindrome("A man, a plan, a canal: Panama");
        assert !solution.isPalindrome("0p");
    }

    @Test
    public void myAtoi() {
        assert 42 == solution.myAtoi("42");
        assert -42 == solution.myAtoi("  -42");
        assert 2 == solution.myAtoi("  2   9");
        assert 4193 == solution.myAtoi("4193 with words");
        assert 0 == solution.myAtoi("words and 987");
        assert Integer.MIN_VALUE == solution.myAtoi("-91283472332");
        assert -2147483647 == solution.myAtoi("-2147483647");
        assert 0 == solution.myAtoi("");
        assert 0 == solution.myAtoi("+-2");
        assert Integer.MAX_VALUE == solution.myAtoi("999999999999");
        assert solution.myAtoi("+23-442") == 23;
        assert 0 == solution.myAtoi("      ");
    }
}