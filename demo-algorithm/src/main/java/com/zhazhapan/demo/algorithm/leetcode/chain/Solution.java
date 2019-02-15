package com.zhazhapan.demo.algorithm.leetcode.chain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/2/15
 **/
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> nodes = new HashSet<>();
        nodes.add(head);
        ListNode node = head.next;
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return null;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
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
