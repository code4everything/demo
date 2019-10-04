package org.code4everything.demo.algorithm.leetcode.contest.c143;

/**
 * @author pantao
 * @since 2019/6/30
 */
public class Contest1104 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int candy = 1;
        int idx = 0;
        while (candies > 0) {
            res[idx] += Math.min(candies, candy);
            candies -= candy;
            candy++;
            idx = (idx + 1) % num_people;
        }
        return res;
    }
}
