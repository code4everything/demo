package com.zhazhapan.demo.algorithm.leetcode.contest;

/**
 * @author pantao
 * @since 2019-01-27
 */
public class Contest984 {

    public String strWithout3a3b(int a, int b) {
        char[] cs = new char[a + b];
        int aCon;
        int bCon;
        if (a > b) {
            aCon = 0;
            bCon = 2;
        } else {
            aCon = 2;
            bCon = 0;
        }
        for (int i = 0; i < cs.length; i++) {
            if (a > 0 && aCon < 2) {
                cs[i] = 'a';
                bCon = 0;
                if (++aCon == 2) {
                    bCon = 0;
                }
                a--;
            } else if (b > 0 && bCon < 2) {
                cs[i] = 'b';
                if (++bCon == 2) {
                    aCon = 0;
                }
                b--;
            }
        }
        return String.valueOf(cs);
    }
}
