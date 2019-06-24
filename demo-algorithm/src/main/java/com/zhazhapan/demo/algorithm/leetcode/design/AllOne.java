package com.zhazhapan.demo.algorithm.leetcode.design;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2019/6/24
 **/
@LeetCode(id = 432, title = "全 O(1) 的数据结构", difficulty = Difficulty.HARD)
public class AllOne {

    private final Map<String, Integer> valueMap = new HashMap<>(256);

    private final Map<String, Integer> indexMap = new HashMap<>(256);

    private final List<String> keys = new ArrayList<>(256);

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int val = valueMap.getOrDefault(key, 0) + 1;
        valueMap.put(key, val);
        if (val == 1) {
            indexMap.put(key, keys.size());
            keys.add(key);
        } else {
            int idx = indexMap.get(key);
            while (idx > 0) {
                String preKey = keys.get(idx - 1);
                int preVal = valueMap.get(preKey);
                if (val > preVal) {
                    indexMap.put(preKey, idx);
                    keys.set(idx, preKey);
                    idx--;
                } else {
                    break;
                }
            }
            indexMap.put(key, idx);
            keys.set(idx, key);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        int val = valueMap.getOrDefault(key, 0) - 1;
        if (val == 0) {
            valueMap.remove(key);
            keys.remove(key);
            indexMap.remove(key);
        } else if (val > 0) {
            valueMap.put(key, val);
            int idx = indexMap.get(key);
            int len = keys.size() - 1;
            while (idx < len) {
                String lastKey = keys.get(idx + 1);
                int lastVal = valueMap.get(lastKey);
                if (val < lastVal) {
                    indexMap.put(lastKey, idx);
                    keys.set(idx, lastKey);
                    idx++;
                } else {
                    break;
                }
            }
            indexMap.put(key, idx);
            keys.set(idx, key);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return keys.isEmpty() ? "" : keys.get(0);
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return keys.isEmpty() ? "" : keys.get(keys.size() - 1);
    }
}
