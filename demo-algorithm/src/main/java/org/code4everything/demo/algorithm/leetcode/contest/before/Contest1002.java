package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-03-03
 */
public class Contest1002 {

    @LeetCode(id = 1002, difficulty = Difficulty.EASY, title = "查找常用字符")
    public List<String> commonChars(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int len = a.length;
        int[][] res = new int[len][26];
        for (int i = 0; i < len; i++) {
            String str = a[i];
            for (int j = 0; j < str.length(); j++) {
                res[i][str.charAt(j) - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int v = findMin(res, len, 0, i);
            for (int j = 0; j < v; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }
        return result;
    }

    private int findMin(int[][] res, int yLen, int y, int x) {
        if (y == yLen) {
            return Integer.MAX_VALUE;
        }
        return Math.min(res[y][x], findMin(res, yLen, y + 1, x));
    }
}
