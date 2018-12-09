package com.zhazhapan.demo.algorithm.leetcode.contest;

import org.junit.Test;

public class Contest941Test {

    @Test
    public void validMountainArray() {
        Contest941 contest941 = new Contest941();
        assert contest941.validMountainArray(new int[]{1, 3, 2, 1});
        assert !contest941.validMountainArray(null);
        assert !contest941.validMountainArray(new int[]{});
        assert !contest941.validMountainArray(new int[]{1, 2, 3, 4, 8, 4, 32, 8});
    }
}
