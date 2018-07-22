package com.zhazhapan.demo.pattern.abstractfactory.impl;

import com.zhazhapan.demo.pattern.abstractfactory.Ferrari;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class FerrariImpl implements Ferrari {

    @Override
    public void brand() {
        System.out.println("ferrari");
    }

    @Override
    public void style() {
        System.out.println("yellow");
    }
}
