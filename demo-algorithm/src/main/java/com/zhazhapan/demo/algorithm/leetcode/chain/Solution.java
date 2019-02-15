package com.zhazhapan.demo.algorithm.leetcode.chain;

/**
 * @author pantao
 * @since 2019/2/15
 **/
public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return false;
        }
        ListNode fast = slow.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}


class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
