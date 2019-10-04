package org.code4everything.demo.algorithm.leetcode.contest.c143;

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
        // 计算当前节点所在的层
        for (; (min & label) != min; level--) {
            min = 1 << (level - 2);
        }
        for (; level > 1; level--, min >>= 1) {
            list.add(0, label);
            // 当前节点所在层的最大值
            int max = (min << 1) - 1;
            // 计算当前节点的父节点的值
            if ((level & 1) == 0) {
                // 偶数层：父节点的值=父节点所在的层的最小值+父节点在所在层的索引位置
                label = (min >> 1) + ((max - label) >> 1);
            } else {
                // 奇数层：父节点的值=父节点所在的层的最大值-父节点在所在层的索引位置
                label = (max >> 1) - ((label - min) >> 1);
            }
        }
        list.add(0, 1);
        return list;
    }
}
