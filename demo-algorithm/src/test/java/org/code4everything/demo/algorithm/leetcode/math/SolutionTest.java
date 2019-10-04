package org.code4everything.demo.algorithm.leetcode.math;

import cn.hutool.core.util.RandomUtil;
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
        int random = 0;
        for (int i = Integer.MIN_VALUE; Integer.MAX_VALUE - random > i; i += random) {
            System.out.println(i);
            assert Integer.bitCount(i) == solution.hammingWeight(i);
            random = RandomUtil.randomInt(0, 1_0000_0000);
        }
    }
}
