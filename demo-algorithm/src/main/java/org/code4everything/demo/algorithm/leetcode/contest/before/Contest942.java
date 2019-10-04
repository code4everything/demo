package org.code4everything.demo.algorithm.leetcode.contest.before;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Contest942 {

    public int[] diStringMatch(String s) {
        int len = s.length();
        int[] a = new int[len + 1];
        a[0] = 500;
        for (int i = 0; i < len; i++) {
            a[i + 1] = a[i] + (s.charAt(i) == 'I' ? 1 : -1);
        }
        return a;
    }
}
