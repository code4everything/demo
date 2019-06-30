package com.zhazhapan.demo.algorithm.leetcode.contest.c143;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/6/30
 */
public class Contest1103 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int level = 32;
        int min = 1 << (level - 1);
        while ((min & label) != min) {
            level--;
            min = 1 << (level - 1);
        }
        while (level > 1) {
            list.add(0, label);
            int max = (min << 1) - 1;
            if ((level & 1) == 0) {
                label = (min >> 1) + ((max - label) / 2);
            } else {
                label = (max >> 1) - ((label - min) / 2);
            }
            min >>= 1;
            level--;
        }
        list.add(0, 1);
        return list;
    }
}
