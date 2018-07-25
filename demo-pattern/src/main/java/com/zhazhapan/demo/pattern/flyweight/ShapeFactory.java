package com.zhazhapan.demo.pattern.flyweight;

import com.zhazhapan.demo.pattern.factory.Shape;

import java.util.HashMap;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
