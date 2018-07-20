package com.zhazhapan.demo.pattern.builder;

/**
 * @author pantao
 * @since 2018-07-20
 */
public class BuilderDemo {

    public static void main(String[] args) {
        ComputorBuilder builder = new ComputorBuilder();
        Computer computer = builder.buildMac();
        System.out.println(computer);
    }
}
