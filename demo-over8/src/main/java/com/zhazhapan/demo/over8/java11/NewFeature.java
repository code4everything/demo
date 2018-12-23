package com.zhazhapan.demo.over8.java11;

import java.util.List;

/**
 * @author pantao
 * @since 2018/12/23
 **/
public class NewFeature {

    public static void main(String[] args) {
        // 类型推断
        var text = "Hello Java 10";
        System.out.println(text.repeat(3));

        // 不可变List
        var list = List.of("A", "B", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);
    }
}
