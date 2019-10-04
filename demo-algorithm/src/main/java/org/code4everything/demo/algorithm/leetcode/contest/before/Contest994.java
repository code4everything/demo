package org.code4everything.demo.algorithm.leetcode.contest.before;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-02-17
 */
public class Contest994 {

    @LeetCode(id = 994, difficulty = Difficulty.EASY, title = "腐烂的橘子")
    public int orangesRotting(int[][] grid) {
        List<Integer> location = new ArrayList<>();
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 2) {
                    location.add(i * colLen + j);
                }
            }
        }
        int minutes = 0;
        while (!location.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < location.size(); i++) {
                int idx = location.get(i);
                int y = idx / colLen;
                int x = idx % colLen;
                helper(grid, rowLen, colLen, next, x + 1, y);
                helper(grid, rowLen, colLen, next, x - 1, y);
                helper(grid, rowLen, colLen, next, x, y + 1);
                helper(grid, rowLen, colLen, next, x, y - 1);
            }
            if (next.isEmpty()) {
                break;
            }
            minutes++;
            location = next;
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    private void helper(int[][] grid, int rowLen, int colLen, List<Integer> next, int x, int y) {
        if (x < 0 || y < 0 || x >= colLen || y >= rowLen) {
            return;
        }
        if (grid[y][x] == 1) {
            grid[y][x] = 2;
            next.add(y * colLen + x);
        }
    }
}
