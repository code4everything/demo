package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest973;
import org.junit.Test;

import java.util.Arrays;

public class Contest973Test {

    @Test
    public void kClosest() {
        Contest973 contest973 = new Contest973();
        sout(contest973.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        sout(contest973.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
    }

    private void sout(int[][] ints) {
        System.out.print("[");
        for (int i = 0; i < ints.length; i++) {
            System.out.print(Arrays.toString(ints[i]) + ", ");
        }
        System.out.println("]");
    }
}
