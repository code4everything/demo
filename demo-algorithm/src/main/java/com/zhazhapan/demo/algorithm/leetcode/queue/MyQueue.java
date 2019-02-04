package com.zhazhapan.demo.algorithm.leetcode.queue;

import java.util.Stack;

/**
 * @author pantao
 * @since 2019-02-04
 */
public class MyQueue {

    Stack<Integer> pushStack = new Stack<>();

    Stack<Integer> popStack = new Stack<>();

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        return pourIn().pop();
    }

    private Stack<Integer> pourIn() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack;
    }

    public int peek() {
        return pourIn().peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
