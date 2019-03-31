package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest954;
import org.junit.Test;

public class Contest954Test {

    @Test
    public void canReorderDoubled() {
        Contest954 contest954 = new Contest954();
        assert !contest954.canReorderDoubled(new int[]{3, 1, 3, 6});
        assert !contest954.canReorderDoubled(new int[]{2, 1, 2, 6});
        assert contest954.canReorderDoubled(new int[]{4, -2, 2, -4});
        assert !contest954.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4});
        assert contest954.canReorderDoubled(new int[]{-6, -3});
        assert contest954.canReorderDoubled(new int[]{2, 1, 2, 1, 1, 1, 2, 2});
        assert contest954.canReorderDoubled(new int[]{-2, -6, -3, 4, -4, 2});
    }
}
