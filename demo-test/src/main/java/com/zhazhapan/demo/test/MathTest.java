package com.zhazhapan.demo.test;

import cn.hutool.core.lang.Console;

/**
 * @author pantao
 * @since 2019/3/6
 **/
public class MathTest {

    public static void main(String[] args) {
        assert -3 == Math.round(-2.6);
        assert 3 == Math.round(2.6);
        Console.log(Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY);
        Console.log(Double.POSITIVE_INFINITY * Double.NEGATIVE_INFINITY);
        Console.log(Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY);
        Console.log(Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY);
        Console.log(Double.POSITIVE_INFINITY / 0);
    }
}
