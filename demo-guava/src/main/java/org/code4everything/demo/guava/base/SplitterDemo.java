package org.code4everything.demo.guava.base;

import com.google.common.base.Splitter;

/**
 * @author pantao
 * @since 2019/10/4
 */
public class SplitterDemo {

    public static void main(String[] args) {
        // 字符串分割，比Java内置的更简单方便
        System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux"));
    }
}
