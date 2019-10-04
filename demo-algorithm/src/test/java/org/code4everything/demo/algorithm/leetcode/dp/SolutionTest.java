package org.code4everything.demo.algorithm.leetcode.dp;

import cn.hutool.core.lang.Console;
import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void maxSubArray() {
        Console.log(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Console.log(solution.maxSubArray(new int[]{-2, 1}));
    }

    @Test
    public void rob() {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 11, 1, 1, 1, 11, 1, 1};
        Console.log(solution.rob(arr));
        int[] test = new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191
                , 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122
                , 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223,
                188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120,
                180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124};
        Console.log(solution.rob(test));
    }

    @Test
    public void coinChange() {
        assert solution.coinChange(new int[]{3, 5}, 22) == 6;
        assert solution.coinChange(new int[]{2}, 3) == -1;
        Console.log(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
