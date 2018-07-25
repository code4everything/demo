package com.zhazhapan.demo.pattern.decorator;

import com.zhazhapan.demo.pattern.factory.Shape;

/**
 * @author pantao
 * @since 2018-07-25
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public abstract void setColor();
}
