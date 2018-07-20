package com.zhazhapan.demo.pattern.builder;

/**
 * @author pantao
 * @since 2018-07-20
 */
public class Computer {

    private String cpu;

    private String disk;

    private String keyboard;

    private String memory;

    private String displayer;

    public Computer() {}

    public Computer(String cpu, String disk, String keyboard, String memory, String displayer) {
        this.cpu = cpu;
        this.disk = disk;
        this.keyboard = keyboard;
        this.memory = memory;
        this.displayer = displayer;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisplayer() {
        return displayer;
    }

    public void setDisplayer(String displayer) {
        this.displayer = displayer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", disk='" + disk + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", memory='" + memory + '\'' +
                ", displayer='" + displayer + '\'' +
                '}';
    }
}
