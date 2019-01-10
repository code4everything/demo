package com.zhazhapan.demo.algorithm.leetcode.binary.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pantao
 * @since 2019-01-03
 */
public class Searcher {

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
        System.out.println((left ? "left >>> " : "right >>> ") + nums[mid]);
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
