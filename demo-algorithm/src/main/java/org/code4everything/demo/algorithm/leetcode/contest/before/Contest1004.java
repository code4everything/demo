package org.code4everything.demo.algorithm.leetcode.contest.before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-03-03
 */
public class Contest1004 {

    public int longestOnes(int[] a, int k) {
        return helper(a, a.length, k, 0);
    }

    private int helper(int[] a, int len, int k, int start) {
        if (start == len) {
            return Integer.MIN_VALUE;
        }
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0, j = start; i < k && j < len; j++) {
            if (a[j] == 0) {
                i++;
                a[j] = 1;
                idxs.add(j);
            }
        }
        int max = maxLongest(a);
        for (int i = 0; i < idxs.size(); i++) {
            a[idxs.get(i)] = 0;
        }
        max = Math.max(max, helper(a, len, k, start + 1));
        return max;
    }

    private int maxLongest(int[] a) {
        int res = 0, cnt = 0;
        for (int num : a) {
            cnt = (num == 0) ? 0 : cnt + 1;
            res = Math.max(res, cnt);
        }
        return res;
    }
}
