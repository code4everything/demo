package org.code4everything.demo.algorithm.leetcode.binary.search;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/1/4
 **/
@LeetCode(id = 374, difficulty = Difficulty.EASY, title = "猜数字大小")
public class GameGuesser extends GuessGame {

    public int guessNumber(int n) {
        long lower = 1;
        long higher = n;
        int num = 1;
        while (lower <= higher) {
            num = (int) ((lower + higher) / 2);
            int res = guess(num);
            if (res == 0) {
                break;
            } else if (res > 0) {
                lower = num + 1;
            } else {
                higher = num - 1;
            }
        }
        return num;
    }
}
