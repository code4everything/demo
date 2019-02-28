package com.zhazhapan.demo.algorithm.leetcode.hash;

import java.util.*;

/**
 * @author pantao
 * @since 2019/2/26
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Set<Integer> has = new HashSet<>();
        while (!has.contains(n)) {
            has.add(n);
            int num = 0;
            while (n > 0) {
                int temp = n % 10;
                num += temp * temp;
                n /= 10;
            }
            if (num == 1) {
                return true;
            }
            n = num;
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
