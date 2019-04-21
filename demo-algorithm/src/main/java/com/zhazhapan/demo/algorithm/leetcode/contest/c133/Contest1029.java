package com.zhazhapan.demo.algorithm.leetcode.contest.c133;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author pantao
 * @since 2019-04-21
 */
public class Contest1029 {

    public int twoCitySchedCost(int[][] costs) {
        Map<Double, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            double x = cost[0];
            double y = cost[1];
            double res = x / y;
            List<Integer> list = map.get(res);
            if (list == null) {
                list = new ArrayList<>();
                map.put(res, list);
            }
            list.add(i);
        }
        int cost = 0;
        int i = 0;
        int len = costs.length / 2;
        for (List<Integer> value : map.values()) {
            for (Integer integer : value) {
                if (i < len) {
                    cost += costs[integer][0];
                } else {
                    cost += costs[integer][1];
                }
                i++;
            }
        }
        return cost;
    }
}
