package org.code4everything.demo.algorithm.leetcode.string

import junit.framework.TestCase
import org.junit.Test

class SolutionKtTest : TestCase() {

    private val solution = SolutionKt()

    @Test
    fun testIsMatch() {
        assert(!solution.isMatch("aaaaaaaaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*"))
    }
}
