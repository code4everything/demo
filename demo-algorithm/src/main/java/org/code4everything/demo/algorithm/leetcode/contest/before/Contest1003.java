package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.Stack;

/**
 * @author pantao
 * @since 2019-03-03
 */
public class Contest1003 {

    @LeetCode(id = 1003, difficulty = Difficulty.MEDIUM, title = "检查替换后的词是否有效")
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
