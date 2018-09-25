package com.zhazhapan.demo.algorithm.common;

import cn.hutool.core.lang.Console;

/**
 * @author pantao
 * @since 2018/9/25
 **/
public class ModPerformance {

    public static void main(String[] args) {
        long min = Integer.MAX_VALUE;
        for (long i = min; i < Long.MAX_VALUE; i++) {
            long start = System.currentTimeMillis();
            long k = i % 2;
            long end = System.currentTimeMillis();
            Console.log("{}\t->\t{}", i, end - start);
        }
    }
}
