package com.zhazhapan.demo.algorithm.leetcode.math;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<String> strings = Arrays.asList("Hollis", "", "HollisChuang", "H", "hollis");
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);
    }

    @Test
    public void hammingWeight() {
        for (int i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i++) {
            assert Integer.bitCount(i) == solution.hammingWeight(i);
        }
    }
}