package com.zhazhapan.demo.algorithm.leetcode.math;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2019/3/25
 **/
public class Solution {

    private final Map<Character, Integer> romanMap = new HashMap<>(8);

    {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    @LeetCode(id = 268, difficulty = Difficulty.EASY, title = "缺失数字")
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        int numSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
        }
        return sum - numSum;
    }

    @LeetCode(id = 190, title = "颠倒二进制位", difficulty = Difficulty.EASY)
    public int reverseBits(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            num = (num << 1) | bit;
            n >>= 1;
        }
        return num;
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    @LeetCode(id = 191, title = "位1的个数", difficulty = Difficulty.EASY)
    public int hammingWeight(int n) {
        int cnt = 0;
        int base = 1;
        if (n < 0) {
            n ^= (1 << 31);
            cnt = 1;
        }
        while (base <= n && base > 0) {
            if (base == (n & base)) {
                cnt++;
            }
            base <<= 1;
        }
        return cnt;
    }

    @LeetCode(id = 13, title = "罗马数字转整数", difficulty = Difficulty.EASY)
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int last = 0;
        int curr;
        for (int i = chars.length - 1; i >= 0; i--) {
            curr = romanMap.get(chars[i]);
            if (curr < last) {
                num -= curr;
            } else {
                num += curr;
            }
            last = curr;
        }
        return num;
    }

    @LeetCode(id = 326, difficulty = Difficulty.EASY, title = "3的幂")
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    @LeetCode(id = 204, title = "计数质数", difficulty = Difficulty.EASY)
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int cnt = 1;
        for (int i = 3; i < n; i++) {
            if (isPreme(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPreme(int num) {
        if ((num & 1) == 1) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @LeetCode(id = 412, difficulty = Difficulty.EASY, title = "Fizz Buzz")
    public List<String> fizzBuzz(int n) {
        final String s1 = "Fizz";
        final String s2 = "Buzz";
        final String s3 = "FizzBuzz";
        String[] strs = new String[n];
        for (int i = 1; i <= n; i++) {
            boolean three = i % 3 == 0;
            boolean five = i % 5 == 0;
            if (three && five) {
                strs[i - 1] = s3;
            } else if (three) {
                strs[i - 1] = s1;
            } else if (five) {
                strs[i - 1] = s2;
            } else {
                strs[i - 1] = String.valueOf(i);
            }
        }
        return Arrays.asList(strs);
    }
}
