package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2018-12-09
 */
public class Contest953 {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            int maxLen = words[i].length();
            int len = words[i - 1].length();
            while (j < maxLen) {
                if (j == len) {
                    return true;
                }
                int idx1 = order.indexOf(words[i - 1].charAt(j));
                int idx2 = order.indexOf(words[i].charAt(j));
                if (idx2 > idx1) {
                    break;
                }
                if (idx2 < idx1 || j == maxLen - 1) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }
}
