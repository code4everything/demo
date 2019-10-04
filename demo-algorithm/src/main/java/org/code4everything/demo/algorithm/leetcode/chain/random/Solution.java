package org.code4everything.demo.algorithm.leetcode.chain.random;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2019-02-23
 */
public class Solution {

    @LeetCode(id = 138, title = "复制带随机指针的链表", difficulty = Difficulty.MEDIUM)
    public Node copyRandomList(Node head) {
        Node root = new Node();
        Node curr = root;
        Map<Node, Node> map = new HashMap<>();
        Node h = head;
        while (h != null) {
            curr.next = new Node();
            curr = curr.next;
            curr.val = h.val;
            map.put(h, curr);
            h = h.next;
        }
        curr = root.next;
        while (head != null) {
            if (head.random != null) {
                curr.random = map.get(head.random);
            }
            curr = curr.next;
            head = head.next;
        }
        return root.next;
    }

    class Node {

        public int val;

        public Node next;

        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
