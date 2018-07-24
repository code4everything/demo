package com.zhazhapan.demo.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author pantao
 * @since 2018/7/24
 */
public class InnerClassTest {

    @Test
    public void testArrayList() {
        System.out.println(new ArrayList<String>() {{
            add("hello");
            add("world");
        }});
    }
}
