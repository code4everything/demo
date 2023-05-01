package org.code4everything.demo.algorithm.leetcode.hash

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    @LeetCode(id = 1376, title = "通知所有员工所需的时间", difficulty = Difficulty.MEDIUM)
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val map = hashMapOf<Int, ArrayList<Int>>()
        manager.forEachIndexed { idx, head ->
            if (head != -1) {
                map.computeIfAbsent(head) { arrayListOf() }.add(idx)
            }
        }

        return numOfMinutes(map, informTime, headID)
    }

    private fun numOfMinutes(map: Map<Int, List<Int>>, informTime: IntArray, head: Int): Int {
        val result = informTime[head]
        var max = 0
        map[head]?.forEach {
            val temp = numOfMinutes(map, informTime, it)
            if (temp > max) {
                max = temp
            }
        }
        return result + max
    }
}
