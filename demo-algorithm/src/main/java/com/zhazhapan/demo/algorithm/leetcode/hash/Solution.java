package com.zhazhapan.demo.algorithm.leetcode.hash;

import com.zhazhapan.demo.algorithm.leetcode.model.TreeNode;

import java.util.*;

/**
 * @author pantao
 * @since 2019/2/26
 **/
public class Solution {

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

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

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
