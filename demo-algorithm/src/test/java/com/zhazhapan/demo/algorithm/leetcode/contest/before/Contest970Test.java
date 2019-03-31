package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest970;
import org.junit.Test;

public class Contest970Test {

    @Test
    public void powerfulIntegers() {
        Contest970 contest970 = new Contest970();
        System.out.println(contest970.powerfulIntegers(2, 3, 10));
        System.out.println(contest970.powerfulIntegers(3, 5, 15));
        System.out.println(contest970.powerfulIntegers(90, 100, 1000000));
        System.out.println(contest970.powerfulIntegers(1, 2, 100));
        System.out.println(contest970.powerfulIntegers(1, 1, 3));
    }
}
