package com.zhazhapan.demo.pattern.abstractfactory;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class CarFactoryDemo {

    public static void main(String[] args) {
        Ferrari ferrari = CarFactory.getFerrari();
        ferrari.brand();
        ferrari.style();
    }
}
