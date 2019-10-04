package org.code4everything.demo.pattern.decorator;

import org.code4everything.demo.pattern.factory.Shape;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void setColor() {
        System.out.println("red color");
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setColor();
    }
}
