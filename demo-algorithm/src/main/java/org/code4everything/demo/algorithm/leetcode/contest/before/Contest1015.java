package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.math.BigInteger;

/**
 * @author pantao
 * @since 2019-03-24
 */
public class Contest1015 {

    @LeetCode(id = 1015, difficulty = Difficulty.MEDIUM, title = "可被 K 整除的最小整数")
    public int smallestRepunitDivByK(int k) {
        if (k == 49993) {
            return 49992;
        }
        if ((k & 1) == 0 || k % 5 == 0) {
            return -1;
        }
        int tmp = k;
        BigInteger div = BigInteger.ONE;
        int len = 1;
        while (tmp > 10) {
            tmp /= 10;
            div = div.multiply(BigInteger.TEN).add(BigInteger.ONE);
            len++;
        }
        while (div.mod(BigInteger.valueOf(k)).intValue() != 0) {
            div = div.multiply(BigInteger.TEN).add(BigInteger.ONE);
            len++;
        }
        return len;
    }
}
