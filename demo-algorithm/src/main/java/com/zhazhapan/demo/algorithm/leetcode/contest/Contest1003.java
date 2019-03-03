package com.zhazhapan.demo.algorithm.leetcode.contest;

import java.util.Stack;

/**
 * @author pantao
 * @since 2019-03-03
 */
public class Contest1003 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() && (c == 'b' || c == 'c')) {
                return false;
            } else if (c == 'a') {
                stack.push(c);
            } else if (c == 'b') {
                if (stack.peek() != 'a') {
                    return false;
                }
                stack.push(c);
            } else {
                char b = stack.pop();
                char a = stack.pop();
                if (a != 'a' || b != 'b') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
