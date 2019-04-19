package com.zhazhapan.demo.test;

import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author pantao
 * @since 2019/4/19
 **/
public class ClassTest {

    @Test
    public void parentChildrenTest() {
        Children children = new Children();
        children.setWeather("cloud");
        children.setName("chengdu");
        Parent parent = children;
        Console.log(parent.getName());
        children.setName("beijing");
        Console.log(parent.getName());
        children = new Children();
        children.setName("shanghai");
        Console.log(parent.getName());
    }

    class Parent {

        String name;

        public Parent() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Children extends Parent {

        String weather;

        Children() {}

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }
    }
}
