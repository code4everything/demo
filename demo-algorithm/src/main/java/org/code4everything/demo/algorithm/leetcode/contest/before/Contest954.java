package org.code4everything.demo.algorithm.leetcode.contest.before;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Contest954 {

    public boolean canReorderDoubled(int[] a) {
        if (a == null) {
            return false;
        }
        if (a.length == 0) {
            return true;
        }
        Arrays.sort(a);
        int offset = 1;
        int len = a.length;
        for (int i = 1; i < len - 1; ) {
            if (doub(a[i - 1], a[i])) {
                i += 2;
                offset = 1;
            } else if (a[i + 1] > 2 * a[i] && a[i] > 0) {
                return false;
            } else if (i + offset == len) {
                return false;
            } else {
                int t = a[i + offset];
                a[i + offset] = a[i];
                a[i] = t;
                offset++;
            }
        }
        return doub(a[len - 2], a[len - 1]);
    }

    private boolean doub(int a, int b) {
        return b == 2 * a || (a < 0 && a == b * 2);
    }
}
