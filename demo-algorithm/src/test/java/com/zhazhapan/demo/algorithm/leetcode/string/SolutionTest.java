package com.zhazhapan.demo.algorithm.leetcode.string;

import cn.hutool.core.lang.Console;
import com.google.common.collect.Lists;
import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        assert solution.isPalindrome("A man, a plan, a canal: Panama");
        assert !solution.isPalindrome("0p");
    }

    @Test
    public void myAtoi() {
        assert 42 == solution.myAtoi("42");
        assert -42 == solution.myAtoi("  -42");
        assert 2 == solution.myAtoi("  2   9");
        assert 4193 == solution.myAtoi("4193 with words");
        assert 0 == solution.myAtoi("words and 987");
        assert Integer.MIN_VALUE == solution.myAtoi("-91283472332");
        assert -2147483647 == solution.myAtoi("-2147483647");
        assert 0 == solution.myAtoi("");
        assert 0 == solution.myAtoi("+-2");
        assert Integer.MAX_VALUE == solution.myAtoi("999999999999");
        assert solution.myAtoi("+23-442") == 23;
        assert 0 == solution.myAtoi("      ");
    }

    @Test
    public void countAndSay() {
        System.out.println(solution.countAndSay(6));
    }

    @Test
    public void wordBreak() {
        assert solution.wordBreak("leetcode", Lists.newArrayList("leet", "code"));
        assert solution.wordBreak("applepenapple", Lists.newArrayList("apple", "pen"));
        assert !solution.wordBreak("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat"));
    }

    @Test
    public void wordBreak2() {
        Console.log(solution.wordBreak2("catsanddog", Lists.newArrayList("cat", "cats", "and", "sand", "dog")));
        Console.log(solution.wordBreak2("pineapplepenapple", Lists.newArrayList("apple", "pen", "applepen", "pine",
                                                                                "pineapple")));
        Console.log(solution.wordBreak2("catsandog", Lists.newArrayList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    public void compareVersion() {
        solution.compareVersion("0.1", "1.1");
    }

    @Test
    public void isAnagram() {
    }
}