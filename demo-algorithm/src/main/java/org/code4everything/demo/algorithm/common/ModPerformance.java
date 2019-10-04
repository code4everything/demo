package org.code4everything.demo.algorithm.common;

/**
 * @author pantao
 * @since 2018/9/25
 **/
public class ModPerformance {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int k = i % 2;
        }
        long end = System.currentTimeMillis();
        System.out.println("use times -> " + (end - start));
    }
}
