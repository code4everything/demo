package com.zhazhapan.demo.pattern.proxy;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class RealImage implements Image {

    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}
