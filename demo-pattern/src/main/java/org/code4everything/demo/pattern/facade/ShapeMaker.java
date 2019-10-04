package org.code4everything.demo.pattern.facade;

import org.code4everything.demo.pattern.factory.Shape;
import org.code4everything.demo.pattern.factory.impl.Circle;
import org.code4everything.demo.pattern.factory.impl.Rectangle;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ShapeMaker {

    private Shape circle;

    private Shape rectangle;

    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }
}
