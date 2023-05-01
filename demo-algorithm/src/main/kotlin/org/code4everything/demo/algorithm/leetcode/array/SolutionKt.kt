package org.code4everything.demo.algorithm.leetcode.array

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    @LeetCode(id = 228, title = "汇总区间", difficulty = Difficulty.EASY)
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return emptyList()
        }

        var start = nums[0]
        var pre = start
        val result = arrayListOf<String>()
        for (i in 1 until nums.size) {
            val num = nums[i]
            if (num == pre + 1) {
                pre = num
            } else {
                result.add(if (start == pre) start.toString() else "$start->$pre")
                start = num
                pre = start
            }
        }

        result.add(if (start == pre) start.toString() else "$start->$pre")
        return result
    }
}
