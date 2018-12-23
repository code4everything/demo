package com.zhazhapan.demo.algorithm.leetcode.contest;

import org.junit.Test;

public class Contest962Test {

    @Test
    public void maxWidthRamp() {
        Contest962 contest962 = new Contest962();
        assert 4 == contest962.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5});
        assert 7 == contest962.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1});
        assert 0 == contest962.maxWidthRamp(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
