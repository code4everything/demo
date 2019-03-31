package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.Contest988;
import com.zhazhapan.demo.algorithm.leetcode.tree.binary.TreeCodec;
import org.junit.Test;

public class Contest988Test {

    @Test
    public void smallestFromLeaf() {
        Contest988 contest988 = new Contest988();
        TreeCodec codec = new TreeCodec();
        assert contest988.smallestFromLeaf(codec.deserialize("19,10")).equals("kt");
        assert contest988.smallestFromLeaf(codec.deserialize("0,(1,3,4),(2,3,4)")).equals("dba");
        assert contest988.smallestFromLeaf(codec.deserialize("25,(1,1,3),(3,0,2)")).equals("adz");
        assert contest988.smallestFromLeaf(codec.deserialize("2,(2,null,(1,0)),(1,0)")).equals("abc");
        assert contest988.smallestFromLeaf(codec.deserialize("0,null,1")).equals("ba");
    }
}
