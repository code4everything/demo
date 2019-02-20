package com.zhazhapan.demo.algorithm.leetcode.chain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/2/15
 **/
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<Integer> integers = new ArrayList<>();
        while (head != null) {
            integers.add(head.val);
            head = head.next;
        }
        for (int i = 0, j = integers.size() - 1; i < j; i++, j--) {
            if (!integers.get(i).equals(integers.get(j))) {
                return false;
            }
        }
        return true;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        int index = 1;
        ListNode node = head.next;
        while (node != null && node.next != null) {
            if (index % 2 == 1) {
                ListNode swap = pre.next;
                pre.next = node.next;
                node.next = node.next.next;
                pre.next.next = swap;
                pre = pre.next;
            } else {
                node = node.next;
            }
            index++;
        }
        return head;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            if (node.val == val) {
                if (node == head) {
                    head = node.next;
                } else {
                    pre.next = node.next;
                }
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            if (head.next == null) {
                head.next = pre;
                return head;
            }
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            nodes.add(node);
            node = node.next;
        }
        if (n == len) {
            return head.next;
        }
        node = nodes.get(len - n - 1);
        node.next = node.next.next;
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int alen = length(headA);
        int blen = length(headB);
        headA = trim(alen, blen, headA);
        headB = trim(blen, alen, headB);
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private ListNode trim(int maxLen, int minLen, ListNode root) {
        if (maxLen > minLen) {
            return trim(maxLen - 1, minLen, root.next);
        }
        return root;
    }

    private int length(ListNode root) {
        int len = 1;
        ListNode node = root.next;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

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
