package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.junit.Test;

public class PairPalindromeTest {

    @Test
    public void palindromePairs() {
        PairPalindrome palindrome = new PairPalindrome();
        System.out.println(palindrome.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(palindrome.palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(palindrome.palindromePairs(new String[]{"a", ""}));
        System.out.println(palindrome.palindromePairs(new String[]{"a", "abc", "aba", ""}));
    }
}
