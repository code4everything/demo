package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1020Test {

    @Test
    public void canThreePartsEqualSum() {
        Contest1013 contest1013 = new Contest1013();
        assert contest1013.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
        assert contest1013.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4});
        assert !contest1013.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1});
        assert contest1013.canThreePartsEqualSum(new int[]{0, 0, 0});
        assert contest1013.canThreePartsEqualSum(new int[]{1, 1, 1});
        assert !contest1013.canThreePartsEqualSum(new int[]{1, 0, 2});
        assert contest1013.canThreePartsEqualSum(new int[]{12, -4, 16, -5, 9, -3, 3, 8, 0});
        assert contest1013.canThreePartsEqualSum(new int[]{10, -7, 13, -14, 30, 16, -3, -16, -27, 27, 19});
    }
}
