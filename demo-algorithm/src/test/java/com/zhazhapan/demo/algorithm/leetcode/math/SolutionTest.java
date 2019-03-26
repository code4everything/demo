package com.zhazhapan.demo.algorithm.leetcode.math;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPowerOfThree() {
        assert !solution.isPowerOfThree(0);
        assert solution.isPowerOfThree(3);
        assert !solution.isPowerOfThree(45);
        assert solution.isPowerOfThree(1);
        assert !solution.isPowerOfThree(2147483647);
    }

    @Test
    public void romanToInt() {
        assert 3 == solution.romanToInt("III");
        assert 4 == solution.romanToInt("IV");
        assert 9 == solution.romanToInt("IX");
        assert 58 == solution.romanToInt("LVIII");
        assert 1994 == solution.romanToInt("MCMXCIV");
    }
}