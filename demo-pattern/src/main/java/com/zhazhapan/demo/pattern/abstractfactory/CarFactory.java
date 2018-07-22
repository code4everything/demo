package com.zhazhapan.demo.pattern.abstractfactory;

import com.zhazhapan.demo.pattern.abstractfactory.impl.FerrariImpl;
import com.zhazhapan.demo.pattern.abstractfactory.impl.LamborghiniImpl;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class CarFactory {

    public static Ferrari getFerrari() {
        return new FerrariImpl();
    }

    public static Lamborghini getLamborghini() {
        return new LamborghiniImpl();
    }
}
