package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

public class GameGuesserTest {

    @Test
    public void guessNumber() {
        GameGuesser guesser = new GameGuesser();
        for (int i = 0; i < 100; i++) {
            int n = Math.abs(RandomUtil.randomInt());
            guesser.setReal(RandomUtil.randomInt(n));
            assert guesser.getReal() == guesser.guessNumber(n);
        }
        guesser.setReal(Integer.MAX_VALUE);
        assert guesser.getReal() == guesser.guessNumber(Integer.MAX_VALUE);
    }
}
