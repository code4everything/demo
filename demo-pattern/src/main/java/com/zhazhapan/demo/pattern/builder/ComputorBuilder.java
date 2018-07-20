package com.zhazhapan.demo.pattern.builder;

/**
 * @author pantao
 * @since 2018-07-20
 */
public class ComputorBuilder {

    private Computer computor = new Computer();

    public Computer buildDell() {
        computor.setCpu("i7");
        computor.setDisk("hd");
        computor.setMemory("4g");
        computor.setDisplayer("1080");
        computor.setKeyboard("small");
        return computor;
    }

    public Computer buildMac() {
        computor.setKeyboard("butter");
        computor.setDisplayer("retina");
        computor.setMemory("8g");
        computor.setDisk("ssd");
        computor.setCpu("i7");
        return computor;
    }
}
