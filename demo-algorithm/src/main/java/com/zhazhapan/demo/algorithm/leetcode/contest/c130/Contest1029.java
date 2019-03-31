package com.zhazhapan.demo.algorithm.leetcode.contest.c130;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-03-31
 */
public class Contest1029 {

    public List<Boolean> prefixesDivBy5(int[] a) {
        List<Boolean> list = new ArrayList<>();
        BigInteger base = BigInteger.ZERO;
        BigInteger five = BigInteger.valueOf(5);
        for (int i = 0; i < a.length; i++) {
            base = (base.shiftLeft(1).add(BigInteger.valueOf(a[i])));
            list.add(base.mod(five).equals(BigInteger.ZERO));
        }
        return list;
    }
}
