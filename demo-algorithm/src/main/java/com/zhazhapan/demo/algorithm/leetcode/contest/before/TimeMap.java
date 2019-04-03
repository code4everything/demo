package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pantao
 * @since 2019-01-27
 */
@LeetCode(id = 981, difficulty = Difficulty.MEDIUM, title = "基于时间的键值存储")
public class TimeMap {

    private final Map<String, List<VTime>> map = new HashMap<>();

    public TimeMap() { }

    public void set(String key, String value, int timestamp) {
        List<VTime> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (timestamp >= list.get(mid).timestamp) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        list.add(start, new VTime(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<VTime> list = map.get(key);
        if (list == null || list.isEmpty() || list.get(0).timestamp > timestamp) {
            return "";
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            VTime time = list.get(i);
            if (time.timestamp <= timestamp) {
                return time.value;
            }
        }
        return "";
    }

    class VTime {

        int timestamp;

        String value;

        public VTime(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
