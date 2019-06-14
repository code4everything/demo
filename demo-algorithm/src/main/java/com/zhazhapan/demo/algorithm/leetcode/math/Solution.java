package com.zhazhapan.demo.algorithm.leetcode.math;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.*;

/**
 * @author pantao
 * @since 2019/3/25
 **/
public class Solution {

    private final Map<Character, Integer> romanMap = new HashMap<>(8);

    {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    @LeetCode(id = 447, title = "回旋镖的数量", difficulty = Difficulty.EASY)
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(len, 1);
        for (int i = 0; i < len; i++) {
            int[] a = points[i];
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                int[] b = points[j];
                int x = Math.abs(a[0] - b[0]);
                int y = Math.abs(a[1] - b[1]);
                int distance = x * x + y * y;
                int n = map.getOrDefault(distance, 0);
                if (n > 0) {
                    ans += 2 * n;
                }
                map.put(distance, n + 1);
            }
            map.clear();
        }
        return ans;
    }

    private Integer distanceHelper(Map<Integer, Integer> map, int[] a, int[] b, int i, int j) {
        if (i < j) {
            i *= 1000;
        } else {
            j *= 1000;
        }
        Integer key = i + j;
        Integer dis = map.get(key);
        if (dis == null) {
            int x = Math.abs(a[0] - b[0]);
            int y = Math.abs(a[1] - b[1]);
            dis = x * x + y * y;
            map.put(key, dis);
        }
        return dis;
    }

    @LeetCode(id = 15, title = "三数之和", difficulty = Difficulty.MEDIUM)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>(nums.length / 3);
        List<Integer> list;
        Map<Integer, Integer> targetMap = new HashMap(nums.length, 1);
        Set<String> has = new HashSet<>(nums.length / 3);
        for (int i = 0; i < nums.length; i++) {
            Integer target = -nums[i];
            if (!targetMap.containsKey(target)) {
                targetMap.put(target, i);
            }
        }
        for (int target : targetMap.keySet()) {
            int targetIdx = targetMap.get(target);
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                if (start == targetIdx) {
                    start++;
                    continue;
                }
                if (end == targetIdx) {
                    end--;
                    continue;
                }
                int res = nums[start] + nums[end];
                if (res == target) {
                    StringBuilder builder = new StringBuilder().append(nums[start]);
                    int pos = -target;
                    if (pos < nums[start]) {
                        builder.insert(0, pos);
                        builder.append(nums[end]);
                    } else if (pos > nums[end]) {
                        builder.append(nums[end]).append(pos);
                    } else {
                        builder.append(pos).append(nums[end]);
                    }
                    String str = builder.toString();
                    if (!has.contains(str)) {
                        list = new ArrayList<>(3);
                        list.add(-target);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        lists.add(list);
                        has.add(str);
                    }
                    // 跳过重复
                    int left = start + 1;
                    int right = end - 1;
                    while (nums[start] == nums[left] && left < right) {
                        left++;
                    }
                    while (nums[end] == nums[right] && right > left) {
                        right--;
                    }
                    start = left;
                    end = right;
                } else if (res > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return lists;
    }

    @LeetCode(id = 9, title = "回文数", difficulty = Difficulty.EASY)
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int origin = x;
        try {
            while (x > 0) {
                reverse *= 10;
                reverse += x % 10;
                x /= 10;
            }
        } catch (Exception e) {
            return false;
        }
        return reverse == origin;
    }

    @LeetCode(title = "第K个语法符号", id = 779, difficulty = Difficulty.MEDIUM)
    public int kthGrammar(int n, int k) {
        return n == 1 ? 0 : kthGrammar(n - 1, (k + 1) >> 1) ^ (k + 1) & 1;
    }

    @LeetCode(title = "斐波那契数", id = 509, difficulty = Difficulty.EASY)
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }

    @LeetCode(id = 134, title = "加油站", difficulty = Difficulty.MEDIUM, selfResolved = false)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int statingStation = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;
            if (currTank < 0) {
                currTank = 0;
                statingStation = i + 1;
            }
        }
        return totalTank >= 0 ? statingStation : -1;
    }

    @LeetCode(id = 371, title = "两整数之和", difficulty = Difficulty.EASY, selfResolved = false)
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    @LeetCode(id = 172, title = "阶乘后的零", difficulty = Difficulty.EASY)
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int s = n / 5;
        return s + trailingZeroes(s);
    }

    @LeetCode(id = 149, title = "直线上最多的点数", difficulty = Difficulty.HARD, selfResolved = false)
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        int n = points.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // clear the map to avoid counting points in different parallel lines
            map.clear();
            int samePoints = 1;
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                // check for the duplicate points
                if (dx == 0 && dy == 0) {
                    samePoints++;
                    continue;
                }

                // find the greatest common divisor of dx and dy
                int gcd = GCD(dx, dy);
                String slope = (dx / gcd) + "#" + (dy / gcd);

                if (!map.containsKey(slope)) {
                    map.put(slope, 1);
                } else {
                    map.put(slope, map.get(slope) + 1);
                }

            }

            if (map.isEmpty()) {
                if (samePoints > result) {
                    result = samePoints;
                }
            } else {
                for (int num : map.values()) {
                    if (num + samePoints > result) {
                        result = num + samePoints;
                    }
                }
            }
        }
        return result;
    }

    private int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b);
    }

    @LeetCode(id = 268, difficulty = Difficulty.EASY, title = "缺失数字")
    public int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        int numSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numSum += nums[i];
        }
        return sum - numSum;
    }

    @LeetCode(id = 190, title = "颠倒二进制位", difficulty = Difficulty.EASY)
    public int reverseBits(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            num = (num << 1) | bit;
            n >>= 1;
        }
        return num;
    }

    @LeetCode(id = 461, difficulty = Difficulty.EASY, title = "汉明距离")
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    @LeetCode(id = 191, title = "位1的个数", difficulty = Difficulty.EASY)
    public int hammingWeight(int n) {
        int cnt = 0;
        int base = 1;
        if (n < 0) {
            n ^= (1 << 31);
            cnt = 1;
        }
        while (base <= n && base > 0) {
            if (base == (n & base)) {
                cnt++;
            }
            base <<= 1;
        }
        return cnt;
    }

    @LeetCode(id = 13, title = "罗马数字转整数", difficulty = Difficulty.EASY)
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        int last = 0;
        int curr;
        for (int i = chars.length - 1; i >= 0; i--) {
            curr = romanMap.get(chars[i]);
            if (curr < last) {
                num -= curr;
            } else {
                num += curr;
            }
            last = curr;
        }
        return num;
    }

    @LeetCode(id = 326, difficulty = Difficulty.EASY, title = "3的幂")
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    @LeetCode(id = 204, title = "计数质数", difficulty = Difficulty.EASY)
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int cnt = 1;
        for (int i = 3; i < n; i++) {
            if (isPreme(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPreme(int num) {
        if ((num & 1) == 1) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @LeetCode(id = 412, difficulty = Difficulty.EASY, title = "Fizz Buzz")
    public List<String> fizzBuzz(int n) {
        final String s1 = "Fizz";
        final String s2 = "Buzz";
        final String s3 = "FizzBuzz";
        String[] strs = new String[n];
        for (int i = 1; i <= n; i++) {
            boolean three = i % 3 == 0;
            boolean five = i % 5 == 0;
            if (three && five) {
                strs[i - 1] = s3;
            } else if (three) {
                strs[i - 1] = s1;
            } else if (five) {
                strs[i - 1] = s2;
            } else {
                strs[i - 1] = String.valueOf(i);
            }
        }
        return Arrays.asList(strs);
    }
}
