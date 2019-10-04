package org.code4everything.demo.guava.collect;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import org.junit.Assert;

/**
 * 比较器
 *
 * @author pantao
 * @since 2018/11/7
 **/
public class OrderingDemo {

    public static void main(String[] args) {
        // Ordering实现了Comparator接口，可以看做是对其的扩展
        Ordering<String> ordering = new Ordering<String>() {
            @Override
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };
        Assert.assertEquals(1, ordering.reverse().compare("pan", "tao."));
    }
}
