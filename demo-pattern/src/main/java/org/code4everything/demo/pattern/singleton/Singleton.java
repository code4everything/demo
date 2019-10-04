package org.code4everything.demo.pattern.singleton;


import java.util.Objects;

/**
 * @author pantao
 * @since 2018/7/9
 */
public class Singleton {

    private static Singleton singleton;

    /**
     * 兼顾效率和线程安全的单例模式
     *
     * @return 单例对象
     */
    public static Singleton getInstance() {
        if (Objects.isNull(singleton)) {
            synchronized (Singleton.class) {
                if (Objects.isNull(singleton)) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
