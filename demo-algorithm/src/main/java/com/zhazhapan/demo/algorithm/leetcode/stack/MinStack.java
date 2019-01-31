package com.zhazhapan.demo.algorithm.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author pantao
 * @since 2019/1/31
 **/
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
