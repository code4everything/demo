package org.code4everything.demo.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author pantao
 * @since 2019/11/22
 */
public class HashMapTest {

    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>(4, 1);
        map.put("a", "b");
        map.put("c", "d");
        map.put("d", "e");
        map.put("f", "g");
    }
}
