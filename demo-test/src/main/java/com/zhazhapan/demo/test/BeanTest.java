package com.zhazhapan.demo.test;

import com.zhazhapan.demo.test.model.ChildTest;
import com.zhazhapan.demo.test.model.Test;
import org.junit.Assert;

/**
 * @author pantao
 * @since 2018/11/10
 */
public class BeanTest {

    public static void main(String[] args) {
        ChildTest childTest = new ChildTest();
        childTest.setId("123");
        childTest.setName("ha");
        childTest.setWeather("cloud");
        Test test = childTest;
        Assert.assertEquals("123", test.getId());
        childTest.setId("235");
        Assert.assertEquals("235", test.getId());
    }
}
