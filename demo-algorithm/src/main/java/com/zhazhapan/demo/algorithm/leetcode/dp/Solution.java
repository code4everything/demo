package com.zhazhapan.demo.algorithm.leetcode.dp;

/**
 * @author pantao
 * @since 2019/3/21
 **/
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxPrice = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i - 1]);
        }
        return maxProfit;
    }

    public int climbStairs(int n) {
        int curr = 1;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            int tmp = curr;
            curr += pre;
            pre = tmp;
        }
        return curr;
    }
}
