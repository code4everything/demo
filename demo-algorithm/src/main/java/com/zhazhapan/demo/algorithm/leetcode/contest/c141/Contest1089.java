package com.zhazhapan.demo.algorithm.leetcode.contest.c141;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019/6/16
 */
public class Contest1089 {

    public void duplicateZeros(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int[] copier = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = 0; j < arr.length; i++) {
            int num = copier[i];
            arr[j++] = num;
            if (num == 0 && j < arr.length) {
                arr[j++] = 0;
            }
        }
    }
}
