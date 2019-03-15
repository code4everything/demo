package com.zhazhapan.demo.algorithm.leetcode.string;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        assert solution.isPalindrome("A man, a plan, a canal: Panama");
        assert !solution.isPalindrome("0p");
    }
}