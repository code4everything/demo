package com.zhazhapan.demo.algorithm.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018/12/23
 **/
public class Contest961 {

    public int repeatedNTimes(int[] A) {
        List<Integer> list = new ArrayList<>();
        int maxLen = A.length / 2 + 1;
        for (int i = 0; i < maxLen; i++) {
            int val = A[i];
            if (list.contains(val)) {
                return val;
            } else {
                list.add(val);
            }
        }
        return A[maxLen];
    }
}
