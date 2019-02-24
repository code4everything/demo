package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-02-24
 */
public class Contest999 {

    public int numRookCaptures(char[][] board) {
        int i = 0, j = 0;
        boolean ret = true;
        for (int m = 0; m < 8 && ret; m++) {
            for (int n = 0; n < 8; n++) {
                if (board[m][n] == 'R') {
                    i = m;
                    j = n;
                    ret = false;
                    break;
                }
            }
        }
        int res = helper(board, i, j, 1, 0);
        res += helper(board, i, j, -1, 0);
        res += helper(board, i, j, 0, 1);
        res += helper(board, i, j, 0, -1);
        return res;
    }

    private int helper(char[][] board, int i, int j, int x, int y) {
        int m = i + x;
        int n = j + y;
        if (m < 0 || m > 7 || n < 0 || n > 7 || board[m][n] == 'B') {
            return 0;
        }
        if (board[m][n] == 'p') {
            return 1;
        }
        return helper(board, m, n, x, y);
    }
}
