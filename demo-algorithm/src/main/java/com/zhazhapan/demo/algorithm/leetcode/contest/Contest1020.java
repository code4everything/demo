package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-03-24
 */
public class Contest1020 {

    public boolean canThreePartsEqualSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum);
        if (sum % 3 == 0) {
            sum /= 3;
            int curr = a[0];
            int len = 1;
            for (int i = 1; i < a.length; i++) {
                if (curr == sum && a[i] != 0) {
                    curr = a[i];
                    len++;
                    if (len == 3) {
                        return true;
                    }
                } else {
                    curr += a[i];
                }
            }
            System.out.println(len + "  " + curr);
            return len == 3 && curr == sum;
        }
        return false;
    }
}
