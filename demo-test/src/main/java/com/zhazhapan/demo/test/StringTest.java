package com.zhazhapan.demo.test;

import cn.hutool.core.lang.Console;

/**
 * @author pantao
 * @since 2019-03-20
 */
public class StringTest {

    public static void main(String[] args) {
        char[] c = {'∑', '†', '¥', 'ø', 'π', 'å', '∂', 'ƒ', '©', '˙', '∆', '˚', '¬', 'Ω', '≈', 'ç', '√', '∫'};
        Console.log(c);
        Console.log(String.format("%+d", 233));
        Console.log(String.format("% d", 233));
        Console.log(String.format("%8.2f", 233.33f));
        Console.log(String.format("%-6d", 233));
        Console.log(String.format("%(,d", -3333333));
    }
}
