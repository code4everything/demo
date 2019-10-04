package org.code4everything.demo.algorithm.leetcode.tree.trie;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2018-12-29
 */
public class WordsSearcher {

    private TrieNode root;

    private List<String> list;

    @LeetCode(id = 212, title = "单词搜索 II", difficulty = Difficulty.HARD)
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        list = new ArrayList<>();
        // 构建前缀树
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                TrieNode[] children = node.children;
                node = children[idx];
                if (node == null) {
                    node = new TrieNode();
                    children[idx] = node;
                }
            }
            node.word = word;
        }
        int maxI = board.length;
        int maxJ = board[0].length;
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                findWords(root, board, null, i, j, maxI - 1, maxJ - 1);
            }
        }
        return list;
    }

    private void findWords(TrieNode node, char[][] board, Route route, int i, int j, int maxI, int maxJ) {
        if (i < 0 || j < 0 || i > maxI || j > maxJ) {
            return;
        }
        if (contains(route, i, j)) {
            return;
        }
        node = node.children[board[i][j] - 'a'];
        if (node == null) {
            return;
        }
        Route newRoute = new Route(i, j, route);
        findWords(node, board, newRoute, i, j - 1, maxI, maxJ);
        findWords(node, board, newRoute, i, j + 1, maxI, maxJ);
        findWords(node, board, newRoute, i - 1, j, maxI, maxJ);
        findWords(node, board, newRoute, i + 1, j, maxI, maxJ);
        if (node.word != null && !list.contains(node.word)) {
            list.add(node.word);
        }
    }

    private boolean contains(Route route, int i, int j) {
        while (route != null) {
            if (route.i == i && route.j == j) {
                return true;
            }
            route = route.next;
        }
        return false;
    }

    private class Route {

        private int i;

        private int j;

        private Route next;

        private Route(int i, int j, Route next) {
            this.i = i;
            this.j = j;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Route{" + "i=" + i + ", j=" + j + ", next=" + next + '}';
        }
    }

    private class TrieNode {

        private String word = null;

        private TrieNode[] children = new TrieNode[26];
    }
}
