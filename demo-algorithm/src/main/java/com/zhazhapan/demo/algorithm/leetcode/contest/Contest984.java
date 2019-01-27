package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-01-27
 */
public class Contest984 {

    public String strWithout3a3b(int a, int b) {
        char[] cs = new char[a + b];
        boolean aWritable = a >= b;
        char pre = '0';
        for (int i = 0; i < cs.length; i++) {
            if (aWritable && a > 0) {
                cs[i] = 'a';
                a--;
            } else if (b > 0) {
                cs[i] = 'b';
                b--;
            }
            if (a <= 0) {
                aWritable = false;
            } else if (b <= 0) {
                aWritable = true;
            } else if (cs[i] == pre) {
                aWritable = !aWritable;
            } else if (a > b && (a / b >= 2)) {
                aWritable = true;
            } else if (b > a && (b / a >= 2)) {
                aWritable = false;
            }
            pre = cs[i];
        }
        return String.valueOf(cs);
    }
}
