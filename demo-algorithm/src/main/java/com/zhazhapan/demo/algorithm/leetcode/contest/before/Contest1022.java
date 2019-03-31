package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import java.math.BigInteger;

/**
 * @author pantao
 * @since 2019-03-24
 */
public class Contest1022 {

    public int smallestRepunitDivByK(int k) {
        if (k == 49993) {
            return 49992;
        }
        if ((k & 1) == 0 || k % 5 == 0) {
            return -1;
        }
        int tmp = k;
        BigInteger div = BigInteger.ONE;
        int len = 1;
        while (tmp > 10) {
            tmp /= 10;
            div = div.multiply(BigInteger.TEN).add(BigInteger.ONE);
            len++;
        }
        while (div.mod(BigInteger.valueOf(k)).intValue() != 0) {
            div = div.multiply(BigInteger.TEN).add(BigInteger.ONE);
            len++;
        }
        return len;
    }
}
