package org.code4everything.demo.pattern.builder;

/**
 * @author pantao
 * @since 2018-07-20
 */
public class BuilderDemo {

    public static void main(String[] args) {
        ComputerBuilder builder = new ComputerBuilder();
        Computer computer = builder.buildMac();
        System.out.println(computer);
    }
}
