package org.code4everything.demo.algorithm.leetcode.stack;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/4/12
 **/
@LeetCode(id = 295, difficulty = Difficulty.HARD, title = "数据流的中位数")
public class MedianFinder {

    private List<Integer> data = new ArrayList<>();

    public void addNum(int num) {
        int start = 0;
        int end = data.size() - 1;
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (num >= data.get(mid)) {
                // 向右边找
                start = mid + 1;
            } else {
                // 向左边找
                end = mid - 1;
            }
        }
        data.add(start, num);
    }

    public double findMedian() {
        if (data.isEmpty()) {
            return 0;
        }
        int idx = data.size() >> 1;
        return (data.size() & 1) == 1 ? data.get(idx) : ((double) data.get(idx - 1) + (double) data.get(idx)) / 2;
    }
}
