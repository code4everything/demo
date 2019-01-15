package com.zhazhapan.demo.algorithm.leetcode.contest;

import org.junit.Test;

public class Contest976Test {

    @Test
    public void largestPerimeter() {
        final Contest976 contest976 = new Contest976();
        System.out.println(contest976.largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(contest976.largestPerimeter(new int[]{1, 2, 1}));
        System.out.println(contest976.largestPerimeter(new int[]{3, 2, 3, 4}));
        System.out.println(contest976.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
