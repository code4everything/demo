package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-03
 */
public class Searcher {

    public int splitArray(int[] nums, int m) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (splitArray(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean splitArray(int[] nums, int m, int sum) {
        int currSum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > sum) {
                i--;
                count++;
                currSum = 0;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int i = 1, j = 0; i < nums.length; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                count += i - j;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        if (nums1 == null || nums1.length == 0) {
            nums = nums2;
        } else if (nums2 == null || nums2.length == 0) {
            nums = nums1;
        } else {
            nums = new int[nums1.length + nums2.length];
            for (int i = 0, j = 0; i + j < nums.length; ) {
                if (j >= nums2.length || (i < nums1.length && nums1[i] < nums2[j])) {
                    nums[i + j] = nums1[i++];
                } else {
                    nums[i + j] = nums2[j++];
                }
            }
        }
        return ((double) nums[nums.length / 2] + (double) nums[(nums.length - 1) / 2]) / 2;
    }

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (nums[i] != 0) {
            int x = nums[i];
            nums[i] = 0;
            i = x;
        }
        return i;
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int res = numbers[start] + numbers[end];
            if (res == target) {
                return new int[]{start + 1, end + 1};
            } else if (res > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[nums1.length];
        int start = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res[start++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(res, start);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] bucket = new boolean[max - min + 1];
        for (int num : nums1) {
            bucket[num - min] = true;
        }
        int index = 0;
        for (int num : nums2) {
            if (num < min || num > max) {
                continue;
            }
            if (bucket[num - min]) {
                nums2[index++] = num;
                bucket[num - min] = false;
            }
        }
        return Arrays.copyOf(nums2, index);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int start = 0;
        int end = len - 1;
        if (target < letters[start] || target >= letters[end]) {
            return letters[0];
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start];
    }

    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num > 46340 ? 46340 : num;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int power = mid * mid;
            if (power == num) {
                return true;
            } else if (power > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        return power(n > 0 ? x : 1 / x, n);
    }

    private double power(double x, int n) {
        if (n == 1 || n == -1) {
            return x;
        }
        double res = power(x, n / 2);
        res *= res;
        if (n % 2 != 0) {
            res *= x;
        }
        return res;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] == nums[end]) {
            return nums[start] == target ? new int[]{start, end} : res;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (nums[0] == target) {
                    res[0] = 0;
                } else {
                    for (int i = mid - 1; i >= 0; i--) {
                        if (nums[i] != target) {
                            res[0] = i + 1;
                            break;
                        }
                    }
                }
                int len = nums.length - 1;
                if (nums[len] == target) {
                    res[1] = len;
                } else {
                    for (int i = mid + 1; i <= len; i++) {
                        if (nums[i] != target) {
                            res[1] = i - 1;
                            break;
                        }
                    }
                }
                break;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private int searchRange(int[] nums, int target, int start, int end, boolean left) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return left ? searchRange(nums, target, start, mid, true) : searchRange(nums, target, mid, end, false);
        } else if (nums[mid] > target) {
            return searchRange(nums, target, start, mid - 1, left);
        } else {
            return searchRange(nums, target, mid + 1, end, left);
        }
    }

    public int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        } else {
            long target = 0;
            int left = 1;
            int right = x / 2;
            while (left <= right) {
                target = (left + right) / 2;
                long sqrt = target * target;
                if (sqrt == x) {
                    break;
                } else if (sqrt > x) {
                    right = (int) target - 1;
                } else if ((target + 1) * (target + 1) > x) {
                    break;
                } else {
                    left = (int) (target + 1);
                }
            }
            return (int) target;
        }
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int idx = (start + end) / 2;
            int num = nums[idx];
            if (num == target) {
                return idx;
            } else if (num > target) {
                end = idx - 1;
            } else {
                start = idx + 1;
            }
        }
        return -1;
    }
}
