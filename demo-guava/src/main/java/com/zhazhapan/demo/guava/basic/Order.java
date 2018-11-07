package com.zhazhapan.demo.guava.basic;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Assert;

/**
 * 比较器
 *
 * @author pantao
 * @since 2018/11/7
 **/
public class Order {

    public static void main(String[] args) {
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        Assert.assertEquals(1, ordering.reverse().compare("pan", "tao."));
    }
}
