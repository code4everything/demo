package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class ContestUnknownTest {

    @Test
    public void numDupDigitsAtMostN() {
        ContestUnknown contestUnknown = new ContestUnknown();
        assert 1 == contestUnknown.numDupDigitsAtMostN(20);
        assert 10 == contestUnknown.numDupDigitsAtMostN(100);
        assert 262 == contestUnknown.numDupDigitsAtMostN(1000);
        System.out.println(contestUnknown.numDupDigitsAtMostN(31034990));
    }
}
