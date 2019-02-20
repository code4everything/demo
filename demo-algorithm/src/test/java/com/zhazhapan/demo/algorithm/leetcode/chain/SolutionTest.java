package com.zhazhapan.demo.algorithm.leetcode.chain;

import org.junit.Test;

public class SolutionTest {

    private Solution solution = new Solution();

    @Test
    public void hasCycle() {
        ListNode one = new ListNode(3);
        assert !solution.hasCycle(one);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode four = new ListNode(4);
        four.next = two;
        zero.next = four;
        two.next = zero;
        assert solution.hasCycle(two);
        one.next = two;
        assert solution.hasCycle(one);
        System.out.println(solution.detectCycle(one));
    }

    @Test
    public void oddEvenList() {

    }
}