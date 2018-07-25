package com.zhazhapan.demo.pattern.responsibility;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
