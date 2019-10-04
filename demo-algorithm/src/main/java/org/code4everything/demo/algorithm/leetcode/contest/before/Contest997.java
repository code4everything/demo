package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-02-24
 */
public class Contest997 {

    @LeetCode(id = 997, difficulty = Difficulty.EASY, title = "找到小镇的法官")
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < trust.length; i++) {
            int[] temp = trust[i];
            lists[temp[0] - 1].add(temp[1] - 1);
        }
        int i = 0;
        int k = 0;
        List<Integer> temp = lists[i++];
        if (temp.isEmpty()) {
            temp = lists[i++];
            k++;
        }
        for (; i < lists.length; i++) {
            if (temp.isEmpty()) {
                return -1;
            }
            List<Integer> swap = lists[i];
            if (k == 0 && swap.isEmpty()) {
                k++;
                continue;
            }
            temp.retainAll(lists[i]);
        }
        return temp.size() == 1 ? temp.get(0) + 1 : -1;
    }
}
