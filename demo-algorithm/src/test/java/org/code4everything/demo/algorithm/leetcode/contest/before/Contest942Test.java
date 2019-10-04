package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

import java.util.Arrays;

public class Contest942Test {

    @Test
    public void diStringMatch() {
        Contest942 contest942 = new Contest942();
        outputArray(contest942.diStringMatch("IDID"));
        outputArray(contest942.diStringMatch("III"));
        outputArray(contest942.diStringMatch("DDI"));
    }

    private void outputArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
