package com.zhazhapan.demo.algorithm.leetcode.contest.before;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2019-01-13
 */
public class Contest973 implements Comparator<Integer[]> {

    private Queue<Integer[]> queue;

    public int[][] kClosest(int[][] points, int k) {
        queue = new PriorityQueue<>(k, this);
        for (int[] point : points) {
            Integer[] integers = new Integer[]{point[0], point[1]};
            if (queue.size() < k) {
                queue.offer(integers);
            } else {
                Integer[] ints = queue.peek();
                if (compare(ints, integers) < 0) {
                    queue.poll();
                    queue.offer(integers);
                }
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            Integer[] ints = queue.poll();
            res[i] = new int[]{ints[0], ints[1]};
        }
        return res;
    }

    @Override
    public int compare(Integer[] o1, Integer[] o2) {
        return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
    }
}
