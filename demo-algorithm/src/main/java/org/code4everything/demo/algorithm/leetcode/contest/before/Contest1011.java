package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019-03-17
 */
public class Contest1011 {

    @LeetCode(id = 1011, difficulty = Difficulty.MEDIUM, title = "在 D 天内送达包裹的能力")
    public int shipWithinDays(int[] weights, int d) {
        int minWeight = weights[0];
        int maxWeight = minWeight;
        for (int i = 1; i < weights.length; i++) {
            minWeight = Math.max(weights[i], minWeight);
            maxWeight += weights[i];
        }
        while (minWeight < maxWeight) {
            int mid = (minWeight + maxWeight) >> 1;
            int dc = 0;
            int i = 0;
            int nowWeight = 0;
            for (; i < weights.length && dc < d; i++) {
                int tmp = nowWeight + weights[i];
                if (tmp > mid) {
                    dc++;
                    nowWeight = weights[i];
                } else {
                    nowWeight = tmp;
                }
            }
            dc++;
            if (dc <= d) {
                maxWeight = mid;
            } else if (minWeight == mid) {
                return maxWeight;
            } else {
                minWeight = mid;
            }
        }
        return minWeight;
    }
}
