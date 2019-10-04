package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/2/3
 **/
public class Contest985 {

    @LeetCode(id = 985, difficulty = Difficulty.EASY, title = "查询后的偶数和")
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
