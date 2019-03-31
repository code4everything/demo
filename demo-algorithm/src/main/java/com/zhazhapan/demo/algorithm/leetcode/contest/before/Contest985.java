package com.zhazhapan.demo.algorithm.leetcode.contest.before;

/**
 * @author pantao
 * @since 2019/2/3
 **/
public class Contest985 {

    public int[] sumEvenAfterQueries(int[] a, int[][] queries) {
        int sum = 0;
        for (int i : a) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        int len = queries.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            int idx = query[1];
            int old = a[idx];
            a[idx] += query[0];
            if (old % 2 == 0) {
                sum -= old;
            }
            if (a[idx] % 2 == 0) {
                sum += a[idx];
            }
            res[i] = sum;
        }
        return res;
    }
}
