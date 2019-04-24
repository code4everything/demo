package com.zhazhapan.demo.test;

import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author pantao
 * @since 2019/4/24
 **/
public class ProxyTest {

    @Test
    public void testProxy() {
        Car car = new Benz();
        car.drive();
    }

    class Car {

        void openDoor() {
            Console.log("open car door");
        }

        void drive() {
            openDoor();
            Console.log("drive car");
        }
    }

    class Benz extends Car {

        @Override
        void openDoor() {
            Console.log("call super open door");
            super.openDoor();
            Console.log("door opened");
        }

        @Override
        void drive() {
            Console.log("call super drive");
            super.drive();
            Console.log("driving");
        }
    }
}
