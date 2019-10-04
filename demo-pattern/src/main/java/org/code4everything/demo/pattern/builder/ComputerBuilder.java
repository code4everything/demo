package org.code4everything.demo.pattern.builder;

/**
 * @author pantao
 * @since 2018-07-20
 */
public class ComputerBuilder {

    private Computer computer = new Computer();

    public Computer buildDell() {
        computer.setCpu("i7");
        computer.setDisk("hd");
        computer.setMemory("4g");
        computer.setDisplayer("1080");
        computer.setKeyboard("small");
        return computer;
    }

    public Computer buildMac() {
        computer.setKeyboard("butter");
        computer.setDisplayer("retina");
        computer.setMemory("8g");
        computer.setDisk("ssd");
        computer.setCpu("i7");
        return computer;
    }
}
