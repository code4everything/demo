package org.code4everything.demo.algorithm.leetcode.math

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    @LeetCode(id = 2413, title = "最小偶倍数", difficulty = Difficulty.EASY)
    fun smallestEvenMultiple(n: Int): Int {
        return if (n and 1 == 1) n shl 1 else n
    }
}
