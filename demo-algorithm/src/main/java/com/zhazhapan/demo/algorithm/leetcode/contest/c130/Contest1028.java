package com.zhazhapan.demo.algorithm.leetcode.contest.c130;

/**
 * @author pantao
 * @since 2019-03-31
 */
public class Contest1028 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        while (n != 1) {
            if (n == -1) {
                builder.insert(0, "1");
                break;
            } else {
                int tmp = n;
                if (tmp > 0) {
                    n = -(tmp >> 1);
                } else if (tmp < 0) {
                    n = (-tmp + 1) >> 1;
                }
                builder.insert(0, tmp - (n * -2));
            }
        }
        return "1" + builder.toString();
    }
}
