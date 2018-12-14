package com.zhazhapan.demo.algorithm.leetcode.tree.binary.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pantao
 * @since 2018/12/14
 **/
public class KthLargest {

    private List<Integer> list;

    private Integer k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = k > 100 ? new LinkedList<>() : new ArrayList<>(k);
        for (int num : nums) {
            insert(num);
        }
    }

    private void insert(int num) {
        if (list.size() == k) {
            if (num > list.get(k - 1)) {
                list.remove(k - 1);
            } else {
                return;
            }
        }
        if (list.isEmpty()) {
            list.add(num);
        } else {
            for (int i = list.size() - 1; i >= -1; i--) {
                if (i == -1) {
                    list.add(0, num);
                } else if (num <= list.get(i)) {
                    list.add(i + 1, num);
                } else {
                    continue;
                }
                break;
            }
        }
    }

    public int add(int val) {
        insert(val);
        return list.get(k - 1);
    }
}
