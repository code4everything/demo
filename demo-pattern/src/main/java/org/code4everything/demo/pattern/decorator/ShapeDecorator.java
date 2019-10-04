package org.code4everything.demo.pattern.decorator;

import org.code4everything.demo.pattern.factory.Shape;

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
