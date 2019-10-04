package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest999Test {

    @Test
    public void numRookCaptures() {
        Contest999 contest999 = new Contest999();
        System.out.println(contest999.numRookCaptures(new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.',
                '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.',
                '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.',
                '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}}));
    }
}
