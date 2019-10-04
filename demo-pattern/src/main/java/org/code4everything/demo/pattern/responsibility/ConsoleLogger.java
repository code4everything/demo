package org.code4everything.demo.pattern.responsibility;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
