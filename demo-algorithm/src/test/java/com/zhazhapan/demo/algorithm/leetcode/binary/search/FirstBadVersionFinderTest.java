package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

public class FirstBadVersionFinderTest {

    @Test
    public void firstBadVersion() {
        FirstBadVersionFinder finder = new FirstBadVersionFinder();
        for (int i = 0; i < 100; i++) {
            int n = Math.abs(RandomUtil.randomInt());
            finder.setFirstBadVersion(Math.abs(RandomUtil.randomInt(n)) + 1);
            assert finder.firstBadVersion(n) == finder.getFirstBadVersion();
        }
        finder.setFirstBadVersion(4);
        assert finder.firstBadVersion(5) == finder.getFirstBadVersion();
    }
}
