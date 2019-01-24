package com.zhazhapan.demo.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-21
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> preList = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                if (j == preList.size()) {
                    list.add(1);
                } else {
                    list.add(preList.get(j - 1) + preList.get(j));
                }
            }
            preList = list;
            lists.add(list);
        }
        return lists;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        int x = 0;
        int y = 0;
        int xDir = 1;
        int yDir = 0;
        int xMin = 0;
        int xMax = n - 1;
        int yMin = 0;
        int yMax = m - 1;
        for (int i = 0; i < m * n; i++) {
            if (x < xMin) {
                x = xMin;
                y = --yMax;
                xDir = 0;
                yDir = -1;
            } else if (x > xMax) {
                x = xMax;
                y = ++yMin;
                xDir = 0;
                yDir = 1;
            } else if (y < yMin) {
                y = yMin;
                x = ++xMin;
                xDir = 1;
                yDir = 0;
            } else if (y > yMax) {
                x = --xMax;
                y = yMax;
                xDir = -1;
                yDir = 0;
            }
            list.add(matrix[y][x]);
            x += xDir;
            y += yDir;
        }
        return list;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int x = 0;
        int y = 0;
        int dir = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[y][x];
            x += dir;
            y -= dir;
            if (x == n) {
                dir = -1;
                y += 2;
                x--;
            } else if (y < 0) {
                dir = -1;
                y = 0;
            } else if (y == m) {
                dir = 1;
                x += 2;
                y--;
            } else if (x < 0) {
                dir = 1;
                x = 0;
            }
        }
        return res;
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if (digits[0] == 9) {
            digits[0] = 0;
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        digits[0]++;
        return digits;
    }

    public int dominantIndex(int[] nums) {
        int max = 0;
        int preMax = 0;
        int maxIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                preMax = max;
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] > preMax) {
                preMax = nums[i];
            }
        }
        return max < (preMax << 1) ? -1 : maxIdx;
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
