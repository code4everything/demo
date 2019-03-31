package com.zhazhapan.demo.algorithm.leetcode.contest.before;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Contest941 {

    public boolean validMountainArray(int[] a) {
        if (a == null) {
            return false;
        }
        int length = a.length;
        if (length > 2 && a[0] < a[1] && a[length - 1] < a[length - 2]) {
            int i = 2;
            for (; i < a.length; i++) {
                if (a[i] > a[i - 1]) {
                    continue;
                }
                if (a[i] == a[i - 1]) {
                    return false;
                }
                if (a[i] < a[i - 1]) {
                    break;
                }
            }
            for (; i < a.length - 1; i++) {
                if (a[i] < a[i - 1]) {
                    continue;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
