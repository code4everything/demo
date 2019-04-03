package com.zhazhapan.demo.algorithm.leetcode.chain;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/2/15
 **/
public class Solution {

    @LeetCode(id = 61, title = "旋转链表", difficulty = Difficulty.MEDIUM)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        node = head;
        for (int i = 1; i + k < len; i++) {
            node = node.next;
        }
        ListNode next = node.next;
        node.next = null;
        node = next;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return next;
    }

    public Node flatten(Node head) {
        if (head != null) {
            lastest(head);
        }
        return head;
    }

    private Node lastest(Node head) {
        Node node = head;
        while (true) {
            Node next = node.next;
            if (node.child != null) {
                node.next = node.child;
                node.child.prev = node;
                node.child = null;
                Node pre = lastest(node.next);
                if (next != null) {
                    pre.next = next;
                    next.prev = pre;
                }
            }
            if (next == null) {
                return node;
            }
            node = next;
        }
    }

    @LeetCode(id = 2, title = "两数相加", difficulty = Difficulty.MEDIUM)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        int adv = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                adv += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                adv += l2.val;
                l2 = l2.next;
            }
            if (head == null) {
                node = head = new ListNode(adv % 10);
            } else {
                node.next = new ListNode(adv % 10);
                node = node.next;
            }
            adv /= 10;
        }
        if (adv > 0) {
            node.next = new ListNode(adv);
        }
        return head;
    }

    @LeetCode(id = 21, title = "合并两个有序链表", difficulty = Difficulty.EASY)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

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

    @LeetCode(id = 27, title = "移除元素", difficulty = Difficulty.EASY)
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

    @LeetCode(id = 19, title = "删除链表的倒数第N个节点", difficulty = Difficulty.MEDIUM)
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

    @LeetCode(id = 142, title = "环形链表 II", difficulty = Difficulty.MEDIUM)
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

    @LeetCode(id = 141, title = "环形链表", difficulty = Difficulty.EASY)
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

    class Node {

        public int val;

        public Node prev;

        public Node next;

        public Node child;

        public Node() {}

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
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
