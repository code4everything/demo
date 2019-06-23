package com.zhazhapan.demo.algorithm.leetcode.contest.c142;

/**
 * @author pantao
 * @since 2019/6/23
 */
public class Contest1093 {

    public double[] sampleStats(int[] count) {
        double[] result = new double[5];
        int min = -1;
        int max = 0;
        long sum = 0;
        long num = 0;
        int weight = 0;
        int maxCnt = 0;
        for (int i = 0; i < count.length; i++) {
            int cnt = count[i];
            if (cnt > 0) {
                // 最小值
                if (min < 0) {
                    min = i;
                }
                // 最大值
                max = i;
                // 统计总和，以及个数
                sum += i * cnt;
                num += cnt;
                // 众数
                if (cnt > maxCnt) {
                    weight = i;
                    maxCnt = cnt;
                }
            }
        }
        result[0] = min;
        result[1] = max;
        result[4] = weight;
        if (num > 0) {
            result[2] = (double) sum / (double) num;

            boolean odd = (num & 1) == 1;
            long idx = (num - 1) >> 1;
            num = 0;
            for (int i = 0; i < count.length; i++) {
                num += count[i];
                if (num > idx) {
                    if (odd || num > (idx + 1)) {
                        result[3] = i;
                    } else {
                        result[3] = (double) (i + i + 1) / 2.0;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
