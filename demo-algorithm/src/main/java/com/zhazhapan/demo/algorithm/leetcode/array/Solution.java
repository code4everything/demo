package com.zhazhapan.demo.algorithm.leetcode.array;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.*;

/**
 * @author pantao
 * @since 2019-01-21
 */
public class Solution {

    @LeetCode(id = 11, title = "盛最多水的容器", difficulty = Difficulty.MEDIUM)
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int heigh = height[i];
            if (heigh < height[j]) {
                i++;
            } else {
                heigh = height[j--];
            }
            max = Math.max(max, heigh * (j - i + 1));
        }
        return max;
    }

    @LeetCode(id = 75, title = "颜色分类", difficulty = Difficulty.MEDIUM)
    public void sortColors(int[] nums) {
        int[] cnts = new int[3];
        for (int num : nums) {
            cnts[num]++;
        }
        int start = 0;
        for (int i = 0; i < cnts.length; i++) {
            Arrays.fill(nums, start, start + cnts[i], i);
            start += cnts[i];
        }
    }

    @LeetCode(id = 80, title = "删除排序数组中的重复项 II", difficulty = Difficulty.MEDIUM)
    public int removeDuplicates2(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int len = 1;
        int val = nums[0];
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == val) {
                if (cnt == 0) {
                    nums[len++] = num;
                }
                cnt++;
            } else {
                val = num;
                nums[len++] = num;
                cnt = 0;
            }
        }
        return len;
    }

    @LeetCode(id = 210, title = "课程表 II", difficulty = Difficulty.MEDIUM, selfResolved = false)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> table = new HashMap<>();
        for (int[] req : prerequisites) {
            indegree[req[0]]++;
            if (!table.containsKey(req[1])) {
                table.put(req[1], new LinkedList<>());
            }
            table.get(req[1]).add(req[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        LinkedList<Integer> order = new LinkedList<>();
        while (queue.size() > 0) {
            int c = queue.poll();
            order.add(c);
            if (table.containsKey(c)) {
                for (int a : table.get(c)) {
                    if (indegree[a] > 0) {
                        indegree[a]--;
                        if (indegree[a] == 0) {
                            queue.add(a);
                        }
                    }
                }
            }
        }
        if (order.size() != numCourses) {
            return new int[0];
        }
        int[] res = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    @LeetCode(refer = "https://www.cnblogs.com/MrSaver/p/9996941.html", id = 207, title = "课程表", difficulty =
            Difficulty.MEDIUM)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pcourse = prerequisites[i][1];
            graph.get(course).add(pcourse);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[curr] == 1) {
            return true;
        }
        if (visited[curr] == 2) {
            return false;
        }
        visited[curr] = 1;
        for (int id : graph.get(curr)) {
            if (dfs(id, graph, visited)) {
                return true;
            }
        }
        visited[curr] = 2;
        return false;
    }

    @LeetCode(id = 300, title = "最长上升子序列", difficulty = Difficulty.MEDIUM)
    public int lengthOfLIS(int[] seq) {
        if (seq == null || seq.length == 0) {
            return 0;
        }
        int[][] array = new int[seq.length][2];
        array[0] = new int[]{seq[0], 1};
        int size = 1;
        for (int i = 1; i < seq.length; i++) {
            int num = seq[i];
            int len = 1;
            for (int j = size - 1; j >= 0; j--) {
                int compare = array[j][0];
                if (num > compare) {
                    len = Math.max(array[j][1] + 1, len);
                } else if (num == compare) {
                    len = Math.max(array[j][1], len);
                }
            }
            array[size++] = new int[]{num, len};
        }
        int max = 0;
        for (int[] ints : array) {
            max = Math.max(max, ints[1]);
        }
        return max;
    }

    @LeetCode(id = 128, title = "最长连续序列", difficulty = Difficulty.HARD)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                cnt++;
            } else if (nums[i] != nums[i - 1]) {
                max = Math.max(cnt, max);
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        return max;
    }

    @LeetCode(difficulty = Difficulty.HARD, title = "计算右侧小于当前元素的个数", id = 315)
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int[] sorted = new int[nums.length];
        Integer[] res = new Integer[nums.length];
        res[nums.length - 1] = 0;
        sorted[0] = nums[nums.length - 1];
        int size = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int start = 0;
            int end = size - 1;
            while (start <= end) {
                int mid = start + ((end - start) >> 1);
                if (nums[i] > sorted[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            res[i] = start;
            System.arraycopy(sorted, start, sorted, start + 1, size - start);
            sorted[start] = nums[i];
            size++;
        }
        return Arrays.asList(res);
    }

    @LeetCode(difficulty = Difficulty.MEDIUM, id = 324, title = "摆动排序 II", selfResolved = false)
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] replica = Arrays.copyOf(nums, len);
        Arrays.sort(replica);
        int mid = (len - 1) / 2;
        int i = mid;
        int k = 0;
        while (--len > mid) {
            nums[k++] = replica[i--];
            nums[k++] = replica[len];
        }
        if (k == nums.length - 1) {
            nums[k] = replica[0];
        }
    }

    @LeetCode(id = 179, title = "最大数", difficulty = Difficulty.MEDIUM, important = true, selfResolved = false)
    public String largestNumber(int[] nums) {
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> {
            if (i1.equals(i2)) {
                return 0;
            }
            long s2 = i2 * 10;
            int tmp = i1;
            int sum = 0;
            int shift = 1;
            while (tmp >= 10) {
                sum += shift * (tmp % 10);
                tmp /= 10;
                shift *= 10;
                s2 *= 10;
            }
            s2 += sum + shift * tmp;

            long s1 = i1 * 10;
            tmp = i2;
            sum = 0;
            shift = 1;
            while (tmp >= 10) {
                sum += shift * (tmp % 10);
                tmp /= 10;
                shift *= 10;
                s1 *= 10;
            }
            s1 += sum + shift * tmp;
            return s2 > s1 ? 1 : -1;
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        String res = builder.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }

    @LeetCode(id = 239, title = "滑动窗口最大值", difficulty = Difficulty.HARD, selfResolved = false)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] max = new int[nums.length - k + 1];
        Queue<Integer> window = new PriorityQueue<>((o1, o2) -> o2 - o1);
        window.offer(Integer.MIN_VALUE);
        for (int i = 0; i < k - 1; i++) {
            if (!window.isEmpty() && nums[i] > window.peek()) {
                window.clear();
            }
            window.offer(nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            int idx = i - k + 1;
            if (!window.isEmpty() && nums[i] > window.peek()) {
                window.clear();
            }
            window.offer(nums[i]);
            max[idx] = window.peek();
            if (max[idx] == nums[idx]) {
                window.poll();
            } else {

            }
        }
        return max;
    }

    @LeetCode(id = 378, difficulty = Difficulty.MEDIUM, title = "有序矩阵中第K小的元素")
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        if (k == len * len) {
            return matrix[len - 1][len - 1];
        }
        int[] idxes = new int[len];
        idxes[0] = 1;
        int j = 0;
        int res = matrix[0][0];
        for (int i = 1; i < k; i++) {
            res = smallestHelper(matrix, len, j, j + 1, idxes);
            if (idxes[j] == len) {
                j++;
            }
        }
        return res;
    }

    private int smallestHelper(int[][] matrix, int len, int x, int y, int[] idxes) {
        if (y == len) {
            return matrix[x][idxes[x]++];
        }
        boolean max = matrix[x][idxes[x]] > matrix[y][idxes[y]];
        if (idxes[y] == 0 || y + 1 == len) {
            return max ? matrix[y][idxes[y]++] : matrix[x][idxes[x]++];
        }
        if (max) {
            return smallestHelper(matrix, len, y, y + 1, idxes);
        } else {
            return smallestHelper(matrix, len, x, y + 1, idxes);
        }
    }

    @LeetCode(id = 215, title = "数组中的第K个最大元素", difficulty = Difficulty.MEDIUM)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    @LeetCode(id = 238, difficulty = Difficulty.MEDIUM, title = "除自身以外数组的乘积", selfResolved = false)
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] res1 = new int[nums.length + 1];
        int[] res2 = new int[nums.length + 1];
        res1[0] = res2[res2.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            res1[i + 1] = res1[i] * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            res2[i] = res2[i + 1] * nums[i];
        }
        output[0] = res2[1];
        for (int i = 1; i < output.length; i++) {
            output[i] = res1[i - 1] * res2[i + 1];
        }
        return output;
    }

    @LeetCode(id = 334, difficulty = Difficulty.MEDIUM, title = "递增的三元子序列", important = true, selfResolved = false)
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int now = nums[i];
            if (now <= first) {
                first = now;
            } else if (now <= second) {
                second = now;
            } else {
                return true;
            }
        }
        return false;
    }

    @LeetCode(id = 152, difficulty = Difficulty.MEDIUM, title = "乘积最大子序列")
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int min = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * tmp));
            curr = Math.max(curr, max);
        }
        return curr;
    }

    @LeetCode(id = 240, title = "搜索二维矩阵 II", difficulty = Difficulty.MEDIUM, selfResolved = false)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            } else if (val > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    @LeetCode(id = 169, title = "求众数", difficulty = Difficulty.EASY)
    public int majorityElement(int[] nums) {
        int least = nums.length / 2;
        Map<Integer, Integer> times = new HashMap<>(least + 1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer time = times.getOrDefault(num, 0) + 1;
            if (time > least) {
                return num;
            }
            times.put(num, time);
        }
        return -1;
    }

    @LeetCode(id = 88, title = "合并两个有序数组", difficulty = Difficulty.EASY)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = Arrays.copyOf(nums1, m);
        for (int i = 0, x = 0, y = 0; i < (m + n); i++) {
            if (y >= n || (x < m && tmp[x] < nums2[y])) {
                nums1[i] = tmp[x++];
            } else {
                nums1[i] = nums2[y++];
            }
        }
    }

    @LeetCode(id = 7, title = "整数反转", difficulty = Difficulty.EASY)
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((Integer.MAX_VALUE / 10) < result || (Integer.MIN_VALUE / 10) > result) {
                return 0;
            }
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    @LeetCode(id = 48, title = "旋转图像", difficulty = Difficulty.MEDIUM)
    public void rotate(int[][] matrix) {
        int yLen = matrix.length;
        if (yLen == 0) {
            return;
        }
        int xLen = matrix[0].length;
        int[][] mirror = new int[yLen][xLen];
        int x = xLen - 1;
        for (int i = 0; i < yLen; i++, x--) {
            for (int j = 0; j < xLen; j++) {
                // 保存到镜像
                mirror[j][x] = matrix[j][x];
                matrix[j][x] = j < x || (i > j && j == x) ? matrix[i][j] : mirror[i][j];
            }
        }
    }

    @LeetCode(id = 122, title = "买卖股票的最佳时机 II", difficulty = Difficulty.EASY)
    public int maxProfit(int[] prices) {
        int profit = 0;
        int start = Integer.MAX_VALUE;
        int currProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int curr = prices[i];
            int diff = curr - start;
            if (diff > currProfit) {
                currProfit = diff;
                continue;
            }
            start = curr;
            profit += currProfit;
            currProfit = 0;
        }
        return profit + currProfit;
    }

    @LeetCode(id = 283, title = "移动零", difficulty = Difficulty.EASY)
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[k++] = num;
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }

    @LeetCode(id = 26, title = "删除排序数组中的重复项", difficulty = Difficulty.EASY)
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int len = 1;
        int val = nums[0];
        for (int num : nums) {
            if (num != val) {
                nums[len++] = num;
                val = num;
            }
        }
        return len;
    }

    @LeetCode(id = 557, title = "反转字符串中的单词 III", difficulty = Difficulty.EASY)
    public String reverseWords2(String s) {
        char[] cs = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 1; i < cs.length; ) {
            while (i < cs.length && cs[i] == ' ') {
                start = ++i;
            }
            while (i < cs.length && cs[i] != ' ') {
                end = i++;
            }
            while (start < end) {
                char c = cs[start];
                cs[start++] = cs[end];
                cs[end--] = c;
            }
        }
        return String.valueOf(cs);
    }

    @LeetCode(id = 151, title = "翻转字符串里的单词", difficulty = Difficulty.MEDIUM)
    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        if (strings.length < 1) {
            return "";
        }
        StringBuilder builder = new StringBuilder(strings[strings.length - 1]);
        for (int i = strings.length - 2; i >= 0; i--) {
            builder.append(" ").append(strings[i]);
        }
        return builder.toString().trim();
    }

    @LeetCode(id = 119, title = "杨辉三角 II", difficulty = Difficulty.EASY)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList = null;
        for (int i = 1; i < rowIndex + 2; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                if (j == preList.size()) {
                    list.add(1);
                } else {
                    list.add(preList.get(j - 1) + preList.get(j));
                }
            }
            preList = list;
        }
        return preList;
    }

    @LeetCode(id = 189, title = "旋转数组", difficulty = Difficulty.EASY)
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k == 0) {
            return;
        }
        k = k % nums.length;
        int[] temp = Arrays.copyOf(nums, nums.length);
        int len = nums.length - k;
        System.arraycopy(temp, 0, nums, k, len);
        System.arraycopy(temp, len, nums, 0, k);
    }

    @LeetCode(id = 209, title = "长度最小的子数组", difficulty = Difficulty.MEDIUM)
    public int minSubArrayLen(int s, int[] nums) {
        Arrays.sort(nums);
        int k = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            s -= nums[i];
            k++;
            if (s <= 0) {
                break;
            }
        }
        return k;
    }

    @LeetCode(id = 485, difficulty = Difficulty.EASY, title = "最大连续1的个数")
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 1) {
                int j = i + 1;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                max = Math.max(max, j - i);
                i = j + 1;
            } else {
                i++;
            }
        }
        return max;
    }

    @LeetCode(id = 561, difficulty = Difficulty.EASY, title = "数组拆分 I")
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    @LeetCode(id = 344, difficulty = Difficulty.EASY, title = "反转字符串")
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            int idx = len - i - 1;
            char c = s[i];
            s[i] = s[idx];
            s[idx] = c;
        }
    }

    @LeetCode(id = 14, title = "最长公共前缀", difficulty = Difficulty.EASY)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return "";
                }
            }
        }
        return prefix;
    }

    @LeetCode(id = 67, title = "二进制求和", difficulty = Difficulty.EASY)
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        char[] ccs = new char[Math.max(al, bl) + 1];
        int k = ccs.length;
        int carry = '0';
        char[] acs = a.toCharArray();
        char[] bcs = b.toCharArray();
        for (int i = al - 1, j = bl - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = (i < 0 ? '0' : acs[i]) + (j < 0 ? '0' : bcs[j]) + carry;
            carry = sum < 146 ? '0' : '1';
            ccs[--k] = sum % 2 == 0 ? '0' : '1';
        }
        if (carry == '1') {
            ccs[0] = '1';
            return String.valueOf(ccs);
        }
        return String.valueOf(ccs, 1, ccs.length - 1);
    }

    @LeetCode(id = 118, title = "杨辉三角", difficulty = Difficulty.EASY)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> preList = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                if (j == preList.size()) {
                    list.add(1);
                } else {
                    list.add(preList.get(j - 1) + preList.get(j));
                }
            }
            preList = list;
            lists.add(list);
        }
        return lists;
    }

    @LeetCode(id = 54, title = "螺旋矩阵", difficulty = Difficulty.MEDIUM)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<>();
        }
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>(m * n);
        int x = 0;
        int y = 0;
        int xDir = 1;
        int yDir = 0;
        int xMin = 0;
        int xMax = n - 1;
        int yMin = 0;
        int yMax = m - 1;
        for (int i = 0; i < m * n; i++) {
            if (x < xMin) {
                x = xMin;
                y = --yMax;
                xDir = 0;
                yDir = -1;
            } else if (x > xMax) {
                x = xMax;
                y = ++yMin;
                xDir = 0;
                yDir = 1;
            } else if (y < yMin) {
                y = yMin;
                x = ++xMin;
                xDir = 1;
                yDir = 0;
            } else if (y > yMax) {
                x = --xMax;
                y = yMax;
                xDir = -1;
                yDir = 0;
            }
            list.add(matrix[y][x]);
            x += xDir;
            y += yDir;
        }
        return list;
    }

    @LeetCode(id = 498, difficulty = Difficulty.MEDIUM, title = "对角线遍历")
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int x = 0;
        int y = 0;
        int dir = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[y][x];
            x += dir;
            y -= dir;
            if (x == n) {
                dir = -1;
                y += 2;
                x--;
            } else if (y < 0) {
                dir = -1;
                y = 0;
            } else if (y == m) {
                dir = 1;
                x += 2;
                y--;
            } else if (x < 0) {
                dir = 1;
                x = 0;
            }
        }
        return res;
    }

    @LeetCode(id = 66, title = "加一", difficulty = Difficulty.EASY)
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if (digits[0] == 9) {
            digits[0] = 0;
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
        digits[0]++;
        return digits;
    }

    @LeetCode(id = 747, difficulty = Difficulty.EASY, title = "至少是其他数字两倍的最大数")
    public int dominantIndex(int[] nums) {
        int max = 0;
        int preMax = 0;
        int maxIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                preMax = max;
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] > preMax) {
                preMax = nums[i];
            }
        }
        return max < (preMax << 1) ? -1 : maxIdx;
    }

    @LeetCode(id = 724, difficulty = Difficulty.EASY, title = "寻找数组的中心索引")
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
