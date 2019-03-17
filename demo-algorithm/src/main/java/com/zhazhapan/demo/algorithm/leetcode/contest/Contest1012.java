package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1012 {

    public int bitwiseComplement(int n) {
        int bit = 1;
        int nc = n;
        while (nc > 1) {
            nc >>= 1;
            bit = (bit << 1) + 1;
        }
        return n ^ bit;
    }
}
