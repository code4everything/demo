package com.zhazhapan.demo.algorithm.leetcode.contest.c144;

/**
 * @author pantao
 * @since 2019/7/7
 */
public class Contest5118 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1];
            for (; start < end; start++) {
                answer[start] += booking[2];
            }
        }
        return answer;
    }
}
