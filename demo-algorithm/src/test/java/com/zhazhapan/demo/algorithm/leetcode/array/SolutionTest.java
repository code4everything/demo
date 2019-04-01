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
        assert solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1}) == 2;
    }

    @Test
    public void minSubArrayLen() {
        assert solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) == 2;
        assert solution.minSubArrayLen(100, new int[0]) == 0;
    }

    @Test
    public void rotate() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(arr, 3);
        Console.log(arr);
        arr = new int[]{-1, -100, 3, 99};
        solution.rotate(arr, 2);
        Console.log(arr);
    }

    @Test
    public void getRow() {
        System.out.println(solution.getRow(3));
    }

    @Test
    public void reverseWords() {
        assert solution.reverseWords("the sky is blue").equals("blue is sky the");
        assert solution.reverseWords(" ").equals("");
        assert solution.reverseWords("1 ").equals("1");
        assert solution.reverseWords(" 1").equals("1");
    }

    @Test
    public void reverseWords2() {
        assert solution.reverseWords2("Let's take LeetCode contest").equals("s'teL ekat edoCteeL tsetnoc");
        assert solution.reverseWords2("").equals("");
    }

    @Test
    public void removeDuplicates() {
        int[] arr = new int[]{1, 1, 2};
        assert solution.removeDuplicates(arr) == 2;
        Console.log(arr);
        arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assert solution.removeDuplicates(arr) == 5;
        Console.log(arr);
    }

    @Test
    public void moveZeroes() {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(arr);
        Console.log(arr);
    }

    @Test
    public void maxProfit() {
        assert 7 == solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assert 4 == solution.maxProfit(new int[]{1, 2, 3, 4, 5});
        assert 0 == solution.maxProfit(new int[]{7, 6, 4, 3, 1});
    }

    @Test
    public void rotate1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        Console.log(matrix);
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);
        Console.log(matrix);
    }

    @Test
    public void searchMatrix() {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        assert solution.searchMatrix(matrix, 5);
        assert !solution.searchMatrix(matrix, 20);
    }
}
