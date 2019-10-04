package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.junit.Test;

public class Contest944Test {

    @Test
    public void minDeletionSize() {
        Contest944 contest944 = new Contest944();
        assert 1 == contest944.minDeletionSize(new String[]{"cba", "daf", "ghi"});
        assert 0 == contest944.minDeletionSize(new String[]{"a", "b"});
        assert 3 == contest944.minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
    }
}
