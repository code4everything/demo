package org.code4everything.demo.pattern.factory.impl;

import org.code4everything.demo.pattern.factory.Shape;

/**
 * @author pantao
 * @since 2018/7/20
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("draw circle");
    }
}
