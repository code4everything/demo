package com.zhazhapan.demo.algorithm.leetcode.binary.search;

/**
 * @author pantao
 * @since 2019/4/2
 **/
public class Solution {

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
