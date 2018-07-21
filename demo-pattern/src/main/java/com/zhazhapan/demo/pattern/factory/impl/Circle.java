package com.zhazhapan.demo.pattern.factory.impl;

import com.zhazhapan.demo.pattern.factory.Shape;

/**
 * @author pantao
 * @since 2018/7/20
 */
public class Circle implements Shape {

    public void draw() {
        System.out.println("draw circle");
    }
}
