package org.code4everything.demo.pattern.factory;

import org.code4everything.demo.pattern.factory.enums.ShapeType;

/**
 * @author pantao
 * @since 2018/7/20
 */
public class ShapeFactoryDemo {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape(ShapeType.CIRCLE);
        shape.draw();
        shape = ShapeFactory.getShape(ShapeType.RECTANGLE);
        shape.draw();
        shape = ShapeFactory.getShape(ShapeType.SQUARE);
        shape.draw();
    }
}
