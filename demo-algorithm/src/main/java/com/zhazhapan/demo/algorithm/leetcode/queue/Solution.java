package com.zhazhapan.demo.algorithm.leetcode.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/1/29
 **/
public class Solution {

    public int openLock(String[] deadends, String target) {
        final String defaultLock = "0000";
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.equals(defaultLock)) {
                return -1;
            }
            visited.add(deadend);
        }
        visited.add(defaultLock);
        List<String> preList = new ArrayList<>();
        preList.add(defaultLock);
        List<String> list;
        int res = 0;
        while (!preList.isEmpty()) {
            list = new ArrayList<>();
            for (int k = 0; k < preList.size(); k++) {
                String lock = preList.get(k);
                if (lock.equals(target)) {
                    return res;
                }
                for (int i = 0; i < 4; i++) {
                    char[] chars = lock.toCharArray();
                    char[] cs = new char[]{chars[i] == '0' ? '9' : (char) (chars[i] - 1), chars[i] == '9' ? '0' :
                            (char) (chars[i] + 1)};
                    for (int j = 0; j < 2; j++) {
                        chars[i] = cs[j];
                        String newLock = String.valueOf(chars);
                        if (!visited.contains(newLock)) {
                            visited.add(newLock);
                            list.add(newLock);
                        }
                    }
                }
            }
            preList = list;
            res++;
        }
        return -1;
    }

    public int numIslands(char[][] grid) {
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j)) {
                    nums++;
                }
            }
        }
        return nums;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0') {
            return false;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        return true;
    }
}
