package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-03-24
 */
public class Contest1022 {

    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || k % 5 == 0) {
            return -1;
        }
        int tmp = k;
        long div = 1;
        int len = 1;
        long max = Long.MAX_VALUE / 10;
        while (tmp > 10) {
            tmp /= 10;
            div = div * 10 + 1;
            len++;
        }
        while (div % k != 0) {
            if (div > max) {
                return -1;
            }
            div = div * 10 + 1;
            len++;
        }
        return len;
    }
}
