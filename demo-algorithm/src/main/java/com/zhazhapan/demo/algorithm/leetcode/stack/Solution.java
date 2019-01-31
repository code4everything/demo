package com.zhazhapan.demo.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * @author pantao
 * @since 2019/1/31
 **/
public class Solution {

    public int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        int[] stack = new int[t.length];
        int top = -1;
        for (int i = 0; i < t.length; i++) {
            while (top > -1 && t[i] > t[stack[top]]) {
                int idx = stack[top--];
                res[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return res;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (c2 + 1 != chars[i] && c2 + 2 != chars[i]) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
