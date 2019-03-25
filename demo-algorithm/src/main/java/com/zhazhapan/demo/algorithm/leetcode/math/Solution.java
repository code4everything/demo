package com.zhazhapan.demo.algorithm.leetcode.math;

import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2019/3/25
 **/
public class Solution {

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
