package com.zhazhapan.demo.pattern.facade;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker maker = new ShapeMaker();
        maker.drawCircle();
        maker.drawRectangle();
        maker.drawSquare();
    }
}
