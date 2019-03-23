package com.zhazhapan.demo.algorithm.leetcode.dp;

/**
 * @author pantao
 * @since 2019/3/21
 **/
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        if (nums.length == 1) {
            return pre;
        }
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp = curr;
            curr = Math.max(nums[i] + pre, curr);
            pre = tmp;
        }
        return curr;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum = sum < 0 ? nums[i] : sum + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

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
