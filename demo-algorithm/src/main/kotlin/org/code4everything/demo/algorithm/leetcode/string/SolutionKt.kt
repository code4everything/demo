package org.code4everything.demo.algorithm.leetcode.string

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    data class CompiledRegExp(val char: Char, var count: Int)

    @LeetCode(id = 10, title = " 正则表达式匹配", difficulty = Difficulty.HARD)
    fun isMatch(s: String, p: String): Boolean {
        val segments = ArrayList<CompiledRegExp>()
        p.forEach {
            if (it == '*') {
                segments.last().count = 0
                if (segments.last() == segments.getOrNull(segments.lastIndex - 1)) {
                    segments.removeAt(segments.lastIndex)
                }
            } else {
                segments.add(CompiledRegExp(it, 1))
            }
        }

        return isMatch(s, segments, 0, 0)
    }

    private fun isMatch(s: String, segments: List<CompiledRegExp>, strIdx: Int, regIdx: Int): Boolean {
        if (strIdx >= s.length) {
            val remaining = segments.stream().skip(regIdx.toLong()).mapToInt { it.count }.sum()
            return remaining == 0
        }
        if (regIdx >= segments.size) {
            return false
        }

        val (char, count) = segments[regIdx]
        val matched = char == '.' || char == s[strIdx]
        var result = false

        if (matched) {
            if (count == 0) {
                result = isMatch(s, segments, strIdx + 1, regIdx)
            }
            result = result || isMatch(s, segments, strIdx + 1, regIdx + 1)
        }
        if (count == 0) {
            result = result || isMatch(s, segments, strIdx, regIdx + 1)
        }

        return result
    }
}
