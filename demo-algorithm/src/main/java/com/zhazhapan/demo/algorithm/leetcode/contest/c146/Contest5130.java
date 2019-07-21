package com.zhazhapan.demo.algorithm.leetcode.contest.c146;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019/07/21
 */
public class Contest5130 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] arr = new int[dominoes.length + 1];
        arr[dominoes.length] = 100;
        for (int i = 0; i < dominoes.length; i++) {
            int tmp[] = dominoes[i];
            arr[i] = Math.min(tmp[0], tmp[1]) * 10 + Math.max(tmp[0], tmp[1]);
        }
        int cnt = 0;
        int tmpCnt = 0;
        int tmp = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            if (i == tmp) {
                tmpCnt++;
            } else {
                tmp = i;
                if (tmpCnt > 0) {
                    cnt += (tmpCnt * (tmpCnt + 1)) >> 1;
                }
                tmpCnt = 0;
            }
        }
        return cnt;
    }
}
