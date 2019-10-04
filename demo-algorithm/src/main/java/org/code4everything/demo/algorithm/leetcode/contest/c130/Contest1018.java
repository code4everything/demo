package org.code4everything.demo.algorithm.leetcode.contest.c130;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-03-31
 */
public class Contest1018 {

    @LeetCode(id = 1018, difficulty = Difficulty.EASY, title = "可被 5 整除的二进制前缀")
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
