package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1013 {

    public int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        for (int i = 1; i < time.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
