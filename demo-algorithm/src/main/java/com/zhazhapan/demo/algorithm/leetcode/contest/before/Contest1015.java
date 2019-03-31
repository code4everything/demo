package com.zhazhapan.demo.algorithm.leetcode.contest.before;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1015 {

    public int numDupDigitsAtMostN(int n) {
        int cnt = 0;
        boolean[] has;
        for (int i = 11; i <= n; i++) {
            has = new boolean[10];
            int tmp = i;
            while (tmp > 0) {
                int mod = tmp % 10;
                if (has[mod]) {
                    cnt++;
                    break;
                }
                has[mod] = true;
                tmp /= 10;
            }
        }
        return cnt;
    }
}
