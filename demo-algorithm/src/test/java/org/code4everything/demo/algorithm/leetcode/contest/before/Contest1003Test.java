package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest1003Test {

    @Test
    public void isValid() {
        Contest1003 contest1003 = new Contest1003();
        assert contest1003.isValid("aabcbc");
        assert contest1003.isValid("abcabcababcc");
        assert !contest1003.isValid("abccba");
        assert !contest1003.isValid("cababc");
    }
}
