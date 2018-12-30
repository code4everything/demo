package com.zhazhapan.demo.algorithm.leetcode.contest;

import com.zhazhapan.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class Contest965Test {

    @Test
    public void isUnivalTree() {
        Contest965 contest965 = new Contest965();
        TreeCodec codec = new TreeCodec();
        assert contest965.isUnivalTree(codec.deserialize("1,(1,1,1),(1,null,1)"));
        assert !contest965.isUnivalTree(codec.deserialize("2,(2,2,2),5"));
    }
}
