package com.zhazhapan.demo.algorithm.leetcode.contest.c144;

/**
 * @author pantao
 * @since 2019/7/7
 */
public class Contest5118 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];
        int[] tag = new int[20001];
        for (int[] booking : bookings) {
            tag[booking[0] - 1] += booking[2];
            tag[booking[1]] -= booking[2];
        }
        int last = 0;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = last + tag[i];
            last = answer[i];
        }
        return answer;
    }
}