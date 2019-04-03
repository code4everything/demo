package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-06
 */
public class Contest970 {

    @LeetCode(id = 970, difficulty = Difficulty.EASY, title = "强整数")
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= bound; i++) {
            int xSum = 1;
            boolean isPower = false;
            while (xSum < i) {
                int num = i - xSum;
                while (num >= 1) {
                    if (num == 1) {
                        isPower = true;
                        break;
                    } else if (y == 1) {
                        break;
                    } else if (num % y == 0) {
                        num /= y;
                    } else {
                        break;
                    }
                }
                if (isPower) {
                    list.add(i);
                    break;
                } else if (x == 1) {
                    break;
                } else {
                    xSum *= x;
                }
            }
        }
        return list;
    }
}
