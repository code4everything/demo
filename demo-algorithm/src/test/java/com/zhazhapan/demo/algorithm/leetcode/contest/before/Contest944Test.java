package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest944;
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
