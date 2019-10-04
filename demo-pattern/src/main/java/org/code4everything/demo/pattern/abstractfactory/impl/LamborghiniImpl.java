package org.code4everything.demo.pattern.abstractfactory.impl;

import org.code4everything.demo.pattern.abstractfactory.Lamborghini;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class LamborghiniImpl implements Lamborghini {

    @Override
    public void brand() {
        System.out.println("lamborghini");
    }

    @Override
    public void style() {
        System.out.println("green");
    }
}
