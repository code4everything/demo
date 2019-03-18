package com.zhazhapan.demo.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pantao
 * @since 2019/3/14
 **/
public class Solution {

    private final char a = 'a';

    private final char z = 'z';

    private final char zero = '0';

    private final char nine = '9';

    public String countAndSay(int n) {
        char[] chars;
        StringBuilder builder = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            chars = builder.toString().toCharArray();
            builder.delete(0, chars.length);
            int cnt = 1;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == chars[j - 1]) {
                    cnt++;
                } else {
                    builder.append(cnt).append(chars[j - 1]);
                    cnt = 1;
                }
            }
            builder.append(cnt).append(chars[chars.length - 1]);
        }
        return builder.toString();
    }

    public int myAtoi(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        long res = 0;
        int i = 0;
        char[] chars = str.toCharArray();
        for (; i < chars.length; ) {
            if (chars[i] == ' ') {
                i++;
            } else {
                break;
            }
        }
        if (i == chars.length) {
            return 0;
        }
        boolean negative = false;
        if (chars[i] == '+' || chars[i] == '-') {
            negative = chars[i++] == '-';
        }
        for (; i < chars.length; i++) {
            int num = chars[i] - '0';
            if (num < 0 || num > 9) {
                break;
            }
            res = res * 10 + num;
            if (negative && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (!negative && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) (negative ? -res : res);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char jc = chars[j];
            char ic = chars[i];
            while (isNotNumOrLetter(jc)) {
                jc = chars[--j];
                if (j == 0) {
                    return true;
                }
            }
            while (isNotNumOrLetter(ic)) {
                ic = chars[++i];
                if (i == chars.length - 1) {
                    return true;
                }
            }
            if (jc != ic) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotNumOrLetter(char c) {
        return c < zero || (c > nine && c < a) || c > z;
    }

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
