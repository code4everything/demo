package com.zhazhapan.demo.pattern.responsibility;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
