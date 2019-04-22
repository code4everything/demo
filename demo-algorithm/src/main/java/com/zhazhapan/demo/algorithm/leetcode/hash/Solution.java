package com.zhazhapan.demo.algorithm.leetcode.hash;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;
import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author pantao
 * @since 2019/2/26
 **/
public class Solution {

    @LeetCode(id = 171, title = "Excel表列序号", difficulty = Difficulty.EASY)
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int idx = 0;
        int res = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            res += Math.pow(26, idx++) * (cs[i] - 64);
        }
        return res;
    }

    @LeetCode(id = 36, title = "有效的数独", difficulty = Difficulty.MEDIUM)
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                if (board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3] != '.' && !cube.add(board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    @LeetCode(id = 347, difficulty = Difficulty.MEDIUM, title = "前K个高频元素")
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        queue.addAll(map.entrySet());
        List<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(queue.poll().getKey());
        }
        return list;
    }

    @LeetCode(id = 454, difficulty = Difficulty.MEDIUM, title = "四数相加 II")
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                Integer key = a[i] + b[j];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                cnt += map.getOrDefault(-c[i] - d[j], 0);
            }
        }
        return cnt;
    }

    @LeetCode(id = 771, difficulty = Difficulty.EASY, title = "宝石与石头")
    public int numJewelsInStones(String j, String s) {
        boolean[] map = new boolean[128];
        char[] js = j.toCharArray();
        for (int i = 0; i < js.length; i++) {
            map[js[i]] = true;
        }
        char[] ss = s.toCharArray();
        int jewels = 0;
        for (int i = 0; i < ss.length; i++) {
            if (map[ss[i]]) {
                jewels++;
            }
        }
        return jewels;
    }

    @LeetCode(id = 652, difficulty = Difficulty.MEDIUM, title = "寻找重复的子树")
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> has = new HashMap<>();
        List<TreeNode> duplicated = new ArrayList<>();
        helper(duplicated, has, root);
        return duplicated;
    }

    private String helper(List<TreeNode> nodes, Map<String, Integer> has, TreeNode node) {
        if (node == null) {
            return "$";
        }
        String str = node.val + "," + helper(nodes, has, node.left) + "," + helper(nodes, has, node.right);
        if (has.containsKey(str)) {
            if (has.get(str) == 0) {
                nodes.add(node);
                has.put(str, 1);
            }
        } else {
            has.put(str, 0);
        }
        return str;
    }

    @LeetCode(id = 49, title = "字母异位词分组", difficulty = Difficulty.MEDIUM)
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        Map<String, List<String>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    @LeetCode(id = 219, difficulty = Difficulty.EASY, title = "存在重复元素 II")
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = 0;
            int x = i;
            while (j++ < k && ++x < nums.length) {
                if (nums[i] == nums[x]) {
                    return true;
                }
            }
        }
        return false;
    }

    @LeetCode(id = 387, difficulty = Difficulty.EASY, title = "字符串中的第一个唯一字符")
    public int firstUniqChar(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] has = new int[26];
        for (int i = 0; i < len; i++) {
            has[chars[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (has[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    @LeetCode(id = 599, difficulty = Difficulty.EASY, title = "两个列表的最小索引总和")
    public String[] findRestaurant(String[] list1, String[] list2) {
        int len1 = list1.length;
        int len2 = list2.length;
        int minSum = len1 + len2;
        String[] rest = new String[len1];
        int idx = 0;
        Map<String, Integer> map = new HashMap<>(len1);
        for (int i = 0; i < len1; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < len2; i++) {
            String key = list2[i];
            if (map.containsKey(key)) {
                int sum = i + map.get(key);
                if (sum < minSum) {
                    idx = 0;
                    rest[idx++] = key;
                    minSum = sum;
                } else if (sum == minSum) {
                    rest[idx++] = key;
                }
            }
        }
        return Arrays.copyOf(rest, idx);
    }

    @LeetCode(id = 205, title = "同构字符串", difficulty = Difficulty.EASY)
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        char[] temp = new char[len];
        Map<Character, Character> maped = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char v = t.charAt(i);
            if (maped.containsKey(c)) {
                temp[i] = maped.get(c);
            } else if (maped.containsValue(v)) {
                return false;
            } else {
                char map = t.charAt(i);
                temp[i] = map;
                maped.put(c, map);
            }
            if (temp[i] != v) {
                return false;
            }
        }
        return t.equals(new String(temp));
    }

    @LeetCode(id = 1, title = "两数之和", difficulty = Difficulty.EASY)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @LeetCode(id = 202, title = "快乐数", difficulty = Difficulty.EASY)
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Set<Integer> has = new HashSet<>();
        while (!has.contains(n)) {
            has.add(n);
            int num = 0;
            while (n > 0) {
                int temp = n % 10;
                num += temp * temp;
                n /= 10;
            }
            if (num == 1) {
                return true;
            }
            n = num;
        }
        return false;
    }

    @LeetCode(id = 136, title = "只出现一次的数字", difficulty = Difficulty.EASY)
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    @LeetCode(id = 217, title = "存在重复元素", difficulty = Difficulty.EASY)
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
