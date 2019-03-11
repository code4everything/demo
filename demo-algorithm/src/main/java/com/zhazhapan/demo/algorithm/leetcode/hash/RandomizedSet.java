package com.zhazhapan.demo.algorithm.leetcode.hash;

import java.util.*;

/**
 * @author pantao
 * @since 2019/3/11
 **/
public class RandomizedSet {

    private List<Integer> data = new ArrayList<>();

    private Map<Integer, Integer> added = new HashMap<>();

    private int size = 0;

    private Random random = new Random();

    public boolean insert(int val) {
        if (added.containsKey(val)) {
            return false;
        }
        data.add(val);
        added.put(val, size++);
        return true;
    }

    public boolean remove(int val) {
        if (added.containsKey(val)) {
            int idx = added.get(val);
            int last = data.get(size - 1);
            data.set(idx, last);
            added.put(last, idx);
            data.remove(--size);
            added.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return data.get(random.nextInt(size));
    }
}
