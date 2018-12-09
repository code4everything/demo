package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Contest944 {

    public int minDeletionSize(String[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }
        int x = a[0].length();
        int y = a.length;
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (a[j].charAt(i) < a[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
