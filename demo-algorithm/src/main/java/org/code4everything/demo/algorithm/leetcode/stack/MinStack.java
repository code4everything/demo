package org.code4everything.demo.algorithm.leetcode.stack;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2019/1/31
 **/
@LeetCode(id = 155, title = "最小栈", difficulty = Difficulty.EASY)
public class MinStack {

    private List<Integer> list = new ArrayList<>();

    private Queue<Integer> mins = new PriorityQueue<>();

    public void push(int x) {
        list.add(x);
        mins.offer(x);
    }

    public void pop() {
        if (!list.isEmpty()) {
            mins.remove(list.remove(list.size() - 1));
        }
    }

    public int top() {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }

    public int getMin() {
        return mins.peek();
    }
}
