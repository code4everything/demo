package com.zhazhapan.demo.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2019/3/14
 **/
public class Solution {

    public boolean isAnagram(String s, String t) {
        int aLen = s.length();
        int bLen = t.length();
        if (aLen != bLen) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(aLen);
        char[] chars = s.toCharArray();
        for (int i = 0; i < aLen; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        chars = t.toCharArray();
        for (int i = 0; i < bLen; i++) {
            Integer val = map.get(chars[i]);
            if (val == null) {
                return false;
            } else if (val == 1) {
                map.remove(chars[i]);
            } else {
                map.put(chars[i], val - 1);
            }
        }
        return map.isEmpty();
    }
}
