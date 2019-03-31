package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.leetcode.contest.before.TimeMap;
import org.junit.Test;

public class TimeMapTest {

    @Test
    public void set() {
    }

    @Test
    public void get() {
        TimeMap kv = new TimeMap();
        kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
        System.out.println(kv.get("foo", 1));
        System.out.println(kv.get("foo", 3));
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4));
        System.out.println(kv.get("foo", 5));
    }
}
