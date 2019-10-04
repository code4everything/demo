package org.code4everything.demo.pattern.decorator;

import org.code4everything.demo.pattern.factory.impl.Circle;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {
        new RedShapeDecorator(new Circle()).draw();
    }
}
