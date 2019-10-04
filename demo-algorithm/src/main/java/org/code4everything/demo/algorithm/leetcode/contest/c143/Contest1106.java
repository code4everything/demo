package org.code4everything.demo.algorithm.leetcode.contest.c143;

import java.util.Stack;

/**
 * @author pantao
 * @since 2019/6/30
 */
public class Contest1106 {

    public boolean parseBoolExpr(String expression) {
        return boolHelper(expression).pop();
    }

    private Stack<Boolean> boolHelper(String exp) {
        Stack<Boolean> stack = new Stack<>();
        Stack<Boolean> returned = null;
        char[] cs = exp.toCharArray();
        int right = cs.length;
        int breaks = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            char c = cs[i];
            if (c == ')') {
                breaks++;
                right = i;
            } else if (c == '(') {
                breaks--;
                if (breaks == 0) {
                    returned = boolHelper(exp.substring(i + 1, right));
                }
            }
            if (breaks > 0) {
                continue;
            }
            if (c == 't') {
                stack.push(true);
            } else if (c == 'f') {
                stack.push(false);
            } else if (c == '!') {
                stack.push(!returned.pop());
            } else if (c == '|') {
                boolean res = false;
                while (!returned.isEmpty()) {
                    res |= returned.pop();
                }
                stack.push(res);
            } else if (c == '&') {
                boolean res = true;
                while (!returned.isEmpty()) {
                    res &= returned.pop();
                }
                stack.push(res);
            }
        }
        return stack;
    }
}
