package com.zhazhapan.demo.test;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

/**
 * @author pantao
 * @since 2018/7/24
 */
public class UuidTest {

    @Test
    public void testUuid() {
        for (int i = 0; i < 100; i++) {
            System.out.println(RandomUtil.simpleUUID());
        }
    }

    @Test
    public void testUid() {
        System.out.println(String.valueOf(System.currentTimeMillis()).length());
        System.out.println(String.valueOf(Long.MAX_VALUE).length());
    }
}
