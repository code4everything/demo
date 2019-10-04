package org.code4everything.demo.algorithm.leetcode.binary.search;

import org.code4everything.demo.algorithm.common.annotation.LeetCode;
import org.code4everything.demo.algorithm.common.enums.Difficulty;

/**
 * @author pantao
 * @since 2019-01-06
 */
public class FirstBadVersionFinder extends VersionControl {

    @LeetCode(id = 278, difficulty = Difficulty.EASY, title = "第一个错误的版本")
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
