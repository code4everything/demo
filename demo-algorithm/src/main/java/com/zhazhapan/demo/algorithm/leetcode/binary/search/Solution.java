package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019/4/2
 **/
public class Solution {

    @LeetCode(id = 887, difficulty = Difficulty.HARD, title = "鸡蛋掉落", selfResolved = false)
    public int superEggDrop(int k, int n) {
        int left = 0;
        int cnt = 0;
        while (left <= n) {
            if (k == 1) {
                cnt += n == left ? 1 : n - left;
                break;
            } else {
                left = ((left + n) >> 1) + 1;
                k--;
            }
            cnt++;
        }
        return cnt;
    }
}
