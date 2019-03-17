package com.zhazhapan.demo.algorithm.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1015 {

    public int numDupDigitsAtMostN(int n) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 11; i <= n; i++) {
            set.clear();
            int tmp = i;
            while (tmp > 0) {
                if (!set.add(tmp % 10)) {
                    cnt++;
                    break;
                }
                tmp /= 10;
            }
        }
        return cnt;
    }
}
