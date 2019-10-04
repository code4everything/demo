package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1010 {

    @LeetCode(id = 1010, difficulty = Difficulty.EASY, title = "总持续时间可被 60 整除的歌曲")
    public int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        for (int i = 1; i < time.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
