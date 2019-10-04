package org.code4everything.demo.pattern.command;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ConcreteCommand extends Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.doSomething();
    }
}
