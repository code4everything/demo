package org.code4everything.demo.algorithm.leetcode.chain

import org.code4everything.demo.algorithm.common.annotation.LeetCode
import org.code4everything.demo.algorithm.common.enums.Difficulty

class SolutionKt {

    @LeetCode(id = 25, title = "K 个一组翻转链表", difficulty = Difficulty.HARD)
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }

        var curr = head
        for (i in 2..k) {
            curr = curr?.next
            if (curr == null) {
                return head
            }
        }

        var pre = reverseKGroup(curr?.next, k)
        curr = head
        for (i in 1..k) {
            val next = curr?.next
            curr?.next = pre
            pre = curr
            curr = next
        }

        return pre
    }
}
