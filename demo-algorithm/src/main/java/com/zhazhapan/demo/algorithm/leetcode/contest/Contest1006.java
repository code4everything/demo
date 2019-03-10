package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-03-10
 */
public class Contest1006 {

    private int met;

    private char[] chars = new char[]{'-', '+', '/', '*'};

    public int clumsy(int n) {
        met = 3;
        StringBuilder builder = new StringBuilder().append(n);
        for (int i = n - 1; i > 0; i--) {
            builder.append(charHelper()).append(i);
        }
        return 1;
    }

    private char charHelper() {
        if (met < 0) {
            met = 3;
        }
        return chars[met--];
    }
}
