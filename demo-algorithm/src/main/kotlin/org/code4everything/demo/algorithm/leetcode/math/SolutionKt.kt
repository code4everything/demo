package org.code4everything.demo.algorithm.leetcode.math

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    @LeetCode(id = 2413, title = "最小偶倍数", difficulty = Difficulty.EASY)
    fun smallestEvenMultiple(n: Int): Int {
        return if (n and 1 == 1) n shl 1 else n
    }

    @LeetCode(id = 1033, title = "移动石子直到连续", difficulty = Difficulty.MEDIUM)
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        val min = minOf(a, minOf(b, c))
        val max = maxOf(a, maxOf(b, c))
        val mid = a + b + c - min - max
        val maxAns = max - min - 2
        val minAns = if (maxAns == 0) 0 else if (max - mid < 3 || mid - min < 3) 1 else 2
        return intArrayOf(minAns, maxAns)
    }
}
