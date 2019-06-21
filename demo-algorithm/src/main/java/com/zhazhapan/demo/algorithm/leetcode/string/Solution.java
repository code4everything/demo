package com.zhazhapan.demo.algorithm.leetcode.string;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.*;

/**
 * @author pantao
 * @since 2019/3/14
 **/
public class Solution {

    private final char a = 'a';

    private final char z = 'z';

    private final char zero = '0';

    private final char nine = '9';

    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

    @LeetCode(id = 165, title = "比较版本号", difficulty = Difficulty.MEDIUM)
    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        int len = Math.max(vers1.length, vers2.length);
        for (int i = 0; i < len; i++) {
            int ver1 = i < vers1.length ? Integer.valueOf(vers1[i]) : 0;
            int ver2 = i < vers2.length ? Integer.valueOf(vers2[i]) : 0;
            if (ver1 > ver2) {
                return 1;
            }
            if (ver1 < ver2) {
                return -1;
            }
        }
        return 0;
    }

    @LeetCode(id = 97, title = "交错字符串", difficulty = Difficulty.HARD, selfResolved = false)
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    boolean left = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                    boolean right = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    dp[i][j] = left || right;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    @LeetCode(id = 68, title = "文本左右对齐", difficulty = Difficulty.HARD, selfResolved = false)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int currentLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < words.length; ) {
            if (currentLen == 0 && currentLen + words[i].length() <= maxWidth || currentLen > 0 && currentLen + 1 + words[i].length() <= maxWidth) {
                end++;
                if (currentLen == 0) {
                    currentLen = currentLen + words[i].length();
                } else {
                    currentLen = currentLen + 1 + words[i].length();
                }
                i++;
            } else {
                int sub = maxWidth - currentLen + (end - start) - 1;
                if (end - start == 1) {
                    String blank = getStringBlank(sub);
                    ans.add(words[start] + blank);
                } else {
                    StringBuilder temp = new StringBuilder();
                    temp.append(words[start]);
                    int averageBlank = sub / ((end - start) - 1);
                    //如果除不尽，计算剩余空格数
                    int missing = sub - averageBlank * ((end - start) - 1);
                    String blank = getStringBlank(averageBlank + 1);
                    int k = 1;
                    for (int j = 0; j < missing; j++) {
                        temp.append(blank + words[start + k]);
                        k++;
                    }
                    blank = getStringBlank(averageBlank);
                    for (; k < (end - start); k++) {
                        temp.append(blank + words[start + k]);
                    }
                    ans.add(temp.toString());

                }
                start = end;
                currentLen = 0;

            }
        }
        StringBuilder temp = new StringBuilder();
        temp.append(words[start]);
        for (int i = 1; i < (end - start); i++) {
            temp.append(" " + words[start + i]);
        }
        temp.append(getStringBlank(maxWidth - currentLen));
        ans.add(temp.toString());
        return ans;
    }

    private String getStringBlank(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    @LeetCode(id = 345, title = "反转字符串中的元音字母", difficulty = Difficulty.MEDIUM)
    public String reverseVowels(String s) {
        char[] origin = s.toCharArray();
        int i = 0;
        int j = origin.length - 1;
        while (i < j) {
            char c1 = origin[i];
            if (vowels.contains(c1)) {
                char c2 = origin[j];
                while (!vowels.contains(c2)) {
                    origin[j--] = c2;
                    c2 = origin[j];
                }
                origin[i++] = c2;
                origin[j--] = c1;
            } else {
                origin[i++] = c1;
            }
        }
        return new String(origin);
    }

    @LeetCode(id = 451, title = "根据字符出现频率排序", difficulty = Difficulty.MEDIUM)
    public String frequencySort(String s) {
        int len = s.length();
        char[] cs = s.toCharArray();
        List<Character> unique = new ArrayList<>();
        Map<Character, Integer> cnt = new HashMap<>(128);
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            int count = cnt.getOrDefault(c, 0);
            if (count == 0) {
                unique.add(c);
            }
            cnt.put(c, count + 1);
        }
        unique.sort((c1, c2) -> cnt.get(c2).compareTo(cnt.get(c1)));
        for (int i = 0, j = 0; i < len; j++) {
            char c = unique.get(j);
            for (int size = cnt.get(c); size > 0; size--, i++) {
                cs[i] = c;
            }
        }
        return new String(cs);
    }

    @LeetCode(id = 127, title = "单词接龙", difficulty = Difficulty.MEDIUM, selfResolved = false)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        boolean[] hashset = new boolean[wordList.size()];
        Deque<String> queue = new ArrayDeque();
        queue.offer(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(beginWord)) {
                hashset[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            ans++;
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return ans;
                }
                for (int j = 0; j < wordList.size(); j++) {
                    if (!hashset[j] && isLegal(cur, wordList.get(j))) {
                        hashset[j] = true;
                        queue.offer(wordList.get(j));
                    }
                }
            }
        }

        return 0;
    }

    private boolean isLegal(String s1, String s2) {
        int sum = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                sum++;
            }
        }
        return sum == 1;
    }

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
