package com.zhazhapan.demo.algorithm.leetcode.contest.c142;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author pantao
 * @since 2019/6/23
 */
public class Contest1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];
            map.put(start, map.getOrDefault(start, 0) + passenger);
            map.put(end, map.getOrDefault(end, 0) - passenger);
        }
        for (Integer value : map.values()) {
            capacity -= value;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
