package com.zhazhapan.demo.algorithm.leetcode.binary.search;

/**
 * @author pantao
 * @since 2019/1/4
 **/
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
