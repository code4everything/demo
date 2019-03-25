package com.zhazhapan.demo.algorithm.leetcode.math;

import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2019/3/25
 **/
public class Solution {

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
