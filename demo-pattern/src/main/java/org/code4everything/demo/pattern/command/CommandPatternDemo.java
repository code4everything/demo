package org.code4everything.demo.pattern.command;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());
        command.execute();
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();
    }
}
