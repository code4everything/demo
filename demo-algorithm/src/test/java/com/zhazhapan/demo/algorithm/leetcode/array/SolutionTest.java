package com.zhazhapan.demo.algorithm.leetcode.array;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void pivotIndex() {
        assert solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) == 3;
        assert solution.pivotIndex(new int[]{1, 2, 3}) == -1;
        assert solution.pivotIndex(new int[]{3, 0}) == 0;
        assert solution.pivotIndex(new int[]{0, 1}) == 1;
        assert solution.pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}) == 4;
    }

    @Test
    public void dominantIndex() {
        assert solution.dominantIndex(new int[]{3, 6, 1, 0}) == 1;
        assert solution.dominantIndex(new int[]{1, 2, 3, 4}) == -1;
        assert solution.dominantIndex(new int[]{2, 3, 6}) == 2;
        assert solution.dominantIndex(new int[]{2, 3, 6, 4}) == -1;
        assert solution.dominantIndex(new int[0]) == -1;
    }

    @Test
    public void plusOne() {
        Console.log(solution.plusOne(new int[]{1, 2, 3}));
        Console.log(solution.plusOne(new int[]{4, 3, 2, 1}));
        Console.log(solution.plusOne(new int[]{8, 9, 9}));
        Console.log(solution.plusOne(new int[]{9, 9, 9, 9}));
    }

    @Test
    public void findDiagonalOrder() {
        Console.log(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        Console.log(solution.findDiagonalOrder(new int[][]{{1, 4}, {2, 5}, {3, 6}}));
        Console.log(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Console.log(solution.findDiagonalOrder(new int[0][0]));
    }

    @Test
    public void spiralOrder() {
        Console.log(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    @Test
    public void generate() {
        Console.log(solution.generate(8));
    }

    @Test
    public void addBinary() {
        assert solution.addBinary("11", "1").equals("100");
        assert solution.addBinary("1010", "1011").equals("10101");
    }

    @Test
    public void longestCommonPrefix() {
        assert solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}).equals("fl");
        assert solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}).equals("");
        System.out.println(solution.longestCommonPrefix(new String[0]));
    }

    @Test
    public void reverseString() {
        solution.reverseString(new char[]{'s', 'a', 'l', 'o'});
    }

    @Test
    public void findMaxConsecutiveOnes() {
        assert solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}) == 3;
        assert solution.findMaxConsecutiveOnes(new int[]{0}) == 0;
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1}));
    }
}
