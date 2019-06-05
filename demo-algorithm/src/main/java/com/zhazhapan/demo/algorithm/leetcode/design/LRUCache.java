package com.zhazhapan.demo.algorithm.leetcode.design;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2019/6/5
 **/
@LeetCode(id = 146, title = "LRU缓存机制", difficulty = Difficulty.HARD)
public class LRUCache {

    private HashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity * 4 / 3 + 1, .75f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
