package org.code4everything.demo.pattern.bridge;

/**
 * @author pantao
 * @since 2018-07-23
 */
public class Circle extends Shape {

    private int x, y, radius;

    protected Circle(DrawApi drawApi, int x, int y, int radius) {
        super(drawApi);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawApi.drawCircle(radius, x, y);
    }
}
