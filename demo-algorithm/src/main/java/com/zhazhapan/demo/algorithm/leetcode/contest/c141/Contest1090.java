package com.zhazhapan.demo.algorithm.leetcode.contest.c141;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2019/6/16
 */
public class Contest1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Queue<Pair> queue = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        for (int i = 0; i < labels.length; i++) {
            queue.offer(new Pair(values[i], labels[i]));
        }
        int sum = 0;
        Map<Integer, Integer> usedLabel = new HashMap<>(numWanted, 1);
        while (numWanted > 0 && !queue.isEmpty()) {
            Pair pair = queue.poll();
            int times = usedLabel.getOrDefault(pair.label, 0);
            if (times < useLimit) {
                sum += pair.value;
                numWanted--;
                usedLabel.put(pair.label, times + 1);
            }
        }
        return sum;
    }

    class Pair {

        int value;

        int label;

        Pair(int value, int label) {
            this.value = value;
            this.label = label;
        }
    }
}
