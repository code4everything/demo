package org.code4everything.demo.pattern.bridge;

/**
 * @author pantao
 * @since 2018-07-23
 */
public class RedCircle implements DrawApi {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
