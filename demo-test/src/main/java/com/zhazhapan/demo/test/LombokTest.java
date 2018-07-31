package com.zhazhapan.demo.test;

import com.zhazhapan.demo.test.model.Test;
import com.zhazhapan.util.RandomUtils;

/**
 * @author pantao
 * @since 2018-07-31
 */
public class LombokTest {

    public static void main(String[] args) {
        Test test = new Test(RandomUtils.getRandomStringOnlyLowerCase(6), "lombok");
        test.setName("hello " + test.getName());
        System.out.println(test.toString());
    }
}
