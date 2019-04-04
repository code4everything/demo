package com.zhazhapan.demo.algorithm.leetcode.string;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @LeetCode(id = 3, title = "无重复字符的最长子串", difficulty = Difficulty.MEDIUM)
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int nowLen = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = s.substring(i - nowLen, i).indexOf(c);
            if (index < 0) {
                maxLen = Math.max(maxLen, ++nowLen);
            } else {
                nowLen -= index;
            }
        }
        return maxLen;
    }

    @LeetCode(id = 140, difficulty = Difficulty.HARD, title = "单词拆分 II")
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (wordDict.isEmpty() || s.length() == 0) {
            return result;
        }
        boolean[] dp = new boolean[s.length() + 1];
        List<Integer> splits = new ArrayList<>(dp.length);
        splits.add(0);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    splits.add(i);
                    break;
                }
            }
        }
        if (dp[s.length()]) {
            wordBreakHelper(s, wordDict, result, splits, 0, splits.size() - 1, "", "");
        }
        return result;
    }

    private void wordBreakHelper(String s, List<String> dict, List<String> result, List<Integer> splits, int start,
                                 int end, String w, String sep) {
        int j = start + 1;
        for (; j <= end; j++) {
            String tmp = s.substring(splits.get(start), splits.get(j));
            if (dict.contains(tmp)) {
                String str = w + sep + tmp;
                if (j == end) {
                    result.add(str);
                } else {
                    wordBreakHelper(s, dict, result, splits, j, end, str, " ");
                }
            }
        }
    }

    @LeetCode(id = 139, title = "单词拆分", difficulty = Difficulty.MEDIUM, important = true, selfResolved = false)
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.isEmpty() || s.length() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    @LeetCode(id = 38, title = "报数", difficulty = Difficulty.EASY)
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

    @LeetCode(id = 8, title = "字符串转换整数 (atoi)", difficulty = Difficulty.MEDIUM)
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

    @LeetCode(id = 125, title = "验证回文串", difficulty = Difficulty.EASY)
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

    @LeetCode(id = 242, difficulty = Difficulty.EASY, title = "有效的字母异位词")
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
