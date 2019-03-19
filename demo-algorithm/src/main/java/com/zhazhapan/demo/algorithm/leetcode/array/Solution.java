package com.zhazhapan.demo.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-21
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = Arrays.copyOf(nums1, m);
        for (int i = 0, x = 0, y = 0; i < (m + n); i++) {
            if (y >= n || (x < m && tmp[x] < nums2[y])) {
                nums1[i] = tmp[x++];
            } else {
                nums1[i] = nums2[y++];
            }
        }
    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((Integer.MAX_VALUE / 10) < result || (Integer.MIN_VALUE / 10) > result) {
                return 0;
            }
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    public void rotate(int[][] matrix) {
        int yLen = matrix.length;
        if (yLen == 0) {
            return;
        }
        int xLen = matrix[0].length;
        int[][] mirror = new int[yLen][xLen];
        int x = xLen - 1;
        for (int i = 0; i < yLen; i++, x--) {
            for (int j = 0; j < xLen; j++) {
                // 保存到镜像
                mirror[j][x] = matrix[j][x];
                matrix[j][x] = j < x || (i > j && j == x) ? matrix[i][j] : mirror[i][j];
            }
        }
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int start = Integer.MAX_VALUE;
        int currProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int curr = prices[i];
            int diff = curr - start;
            if (diff > currProfit) {
                currProfit = diff;
                continue;
            }
            start = curr;
            profit += currProfit;
            currProfit = 0;
        }
        return profit + currProfit;
    }

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[k++] = num;
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int len = 1;
        int val = nums[0];
        for (int num : nums) {
            if (num != val) {
                nums[len++] = num;
                val = num;
            }
        }
        return len;
    }

    public String reverseWords2(String s) {
        char[] cs = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < cs.length; ) {
            while (i < cs.length && cs[i] == ' ') {
                start = ++i;
            }
            while (i < cs.length && cs[i] != ' ') {
                end = i++;
            }
            while (start < end) {
                char c = cs[start];
                cs[start++] = cs[end];
                cs[end--] = c;
            }
        }
        return String.valueOf(cs);
    }

    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        if (strings.length < 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder(strings[strings.length - 1]);
        for (int i = strings.length - 2; i >= 0; i--) {
            builder.append(" ").append(strings[i]);
        }
        return builder.toString().trim();
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = null;
        for (int i = 1; i < rowIndex + 2; i++) {
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
        }
        return preList;
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        int len = nums.length - k;
        System.arraycopy(temp, 0, nums, k, len);
        System.arraycopy(temp, len, nums, 0, k);
    }

    public int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int k = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            s -= nums[i];
            k++;
            if (s <= 0) {
                break;
            }
        }
        return k;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 1) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                max = Math.max(max, j - i);
                i = j + 1;
            } else {
                i++;
            }
        }
        return max;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            int idx = len - i - 1;
            char c = s[i];
            s[i] = s[idx];
            s[idx] = c;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        char[] ccs = new char[Math.max(al, bl) + 1];
        int k = ccs.length;
        int carry = '0';
        char[] acs = a.toCharArray();
        char[] bcs = b.toCharArray();
        for (int i = al - 1, j = bl - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = (i < 0 ? '0' : acs[i]) + (j < 0 ? '0' : bcs[j]) + carry;
            carry = sum < 146 ? '0' : '1';
            ccs[--k] = sum % 2 == 0 ? '0' : '1';
        }
        if (carry == '1') {
            ccs[0] = '1';
            return String.valueOf(ccs);
        }
        return String.valueOf(ccs, 1, ccs.length - 1);
    }

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
