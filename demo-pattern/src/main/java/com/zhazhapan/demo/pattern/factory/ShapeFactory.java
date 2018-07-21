package com.zhazhapan.demo.pattern.factory;

import com.zhazhapan.demo.pattern.factory.enums.ShapeType;
import com.zhazhapan.demo.pattern.factory.impl.Circle;
import com.zhazhapan.demo.pattern.factory.impl.Rectangle;
import com.zhazhapan.demo.pattern.factory.impl.Square;

/**
 * @author pantao
 * @since 2018/7/20
 */
public class ShapeFactory {

    public static Shape getShape(ShapeType shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case CIRCLE:
                shape = new Circle();
                break;
            case SQUARE:
                shape = new Square();
                break;
            case RECTANGLE:
                shape = new Rectangle();
                break;
            default:
                break;
        }
        return shape;
    }
}
