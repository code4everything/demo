package com.zhazhapan.demo.test;

import com.zhazhapan.modules.constant.ValueConsts;
import org.junit.Test;

import java.util.Random;

/**
 * @author pantao
 * @since 2018/7/16
 */
public class RandomTest {

    /**
     * random long没有上线设置
     */
    @Test
    public void testRandomLong() {
        for (int i = 0; i < ValueConsts.ONE_HUNDRED_INT; i++) {
            System.out.println(new Random().nextLong());
        }
    }

    @Test
    public void testRandomInt() {
        for (int i = 0; i < ValueConsts.ONE_HUNDRED_INT; i++) {
            System.out.println(new Random().nextInt());
        }
        System.out.println("-------------------------------------------");
        for (int i = 0; i < ValueConsts.ONE_HUNDRED_INT; i++) {
            System.out.println(new Random().nextInt(Integer.MAX_VALUE));
        }
    }
}
