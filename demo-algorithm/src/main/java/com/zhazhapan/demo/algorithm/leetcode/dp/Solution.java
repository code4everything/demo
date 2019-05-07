package com.zhazhapan.demo.algorithm.leetcode.dp;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/3/21
 **/
public class Solution {

    private int max = Integer.MIN_VALUE;

    @LeetCode(id = 322, title = "零钱兑换", difficulty = Difficulty.MEDIUM)
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return coinHelper(coins, coins.length - 1, amount);
    }

    private int coinHelper(int[] coins, int high, int amount) {
        if (high < 0) {
            return -1;
        }
        int coin = coins[high];
        int res = amount / coin;
        int mod = amount % coin;
        if (mod == 0) {
            return res;
        }
        int result = -1;
        while (res >= 0 && high > 0) {
            int num = coinHelper(coins, high - 1, mod);
            if (num > 0) {
                int tmp = res + num;
                result = result > 0 ? Math.min(result, tmp) : tmp;
            }
            res--;
            mod += coin;
        }
        return result;
    }

    @LeetCode(title = "二叉树中的最大路径和", difficulty = Difficulty.HARD, id = 124, selfResolved = false)
    public int maxPathSum(TreeNode root) {
        sumHelper(root);
        return max;
    }

    private int sumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(sumHelper(root.left), 0);
        int right = Math.max(sumHelper(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    @LeetCode(id = 395, title = "至少有K个重复字符的最长子串", difficulty = Difficulty.MEDIUM, selfResolved = false)
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder regex = new StringBuilder();
        String sep = "";
        int letters = 0;
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        for (Map.Entry<Character, Integer> entry : set) {
            if (entry.getValue() < k) {
                regex.append(sep).append(entry.getKey());
                sep = "|";
                letters++;
            }
        }
        if (letters == 0) {
            return s.length();
        }
        if (letters == map.size()) {
            return 0;
        }
        String[] strs = s.split(regex.toString());
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() > 0) {
                max = Math.max(max, longestSubstring(str, k));
            }
        }
        return max;
    }

    @LeetCode(id = 198, title = "打家劫舍", difficulty = Difficulty.EASY)
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

    @LeetCode(id = 53, title = "最大子序和", difficulty = Difficulty.EASY)
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = max;
        for (int i = 1; i < nums.length; i++) {
            sum = sum < 0 ? nums[i] : sum + nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    @LeetCode(id = 121, title = "买卖股票的最佳时机", difficulty = Difficulty.EASY)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxPrice = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i - 1]);
        }
        return maxProfit;
    }

    @LeetCode(id = 70, title = "爬楼梯", difficulty = Difficulty.EASY)
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
