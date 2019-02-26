package com.zhazhapan.demo.algorithm.leetcode.hash;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019/2/26
 **/
public class Solution {

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
