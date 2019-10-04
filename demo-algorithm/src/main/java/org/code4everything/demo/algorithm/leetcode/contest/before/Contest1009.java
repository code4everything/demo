package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1009 {

    @LeetCode(id = 1009, difficulty = Difficulty.EASY, title = "十进制整数的反码")
    public int bitwiseComplement(int n) {
        int bit = 1;
        int nc = n;
        while (nc > 1) {
            nc >>= 1;
            bit = (bit << 1) + 1;
        }
        return n ^ bit;
    }
}
