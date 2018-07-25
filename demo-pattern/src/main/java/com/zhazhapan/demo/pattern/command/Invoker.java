package com.zhazhapan.demo.pattern.command;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}
