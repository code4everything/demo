package org.code4everything.demo.pattern.bridge;

/**
 * @author pantao
 * @since 2018-07-23
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape shape = new Circle(new RedCircle(), 100, 100, 10);
        shape.draw();
    }
}
