package com.zhazhapan.demo.pattern.bridge;

/**
 * @author pantao
 * @since 2018-07-23
 */
public abstract class Shape {

    DrawApi drawApi;

    protected Shape(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    /**
     * 画
     */
    public abstract void draw();
}
