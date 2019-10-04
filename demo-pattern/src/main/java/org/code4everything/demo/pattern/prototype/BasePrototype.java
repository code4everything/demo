package org.code4everything.demo.pattern.prototype;

/**
 * @author pantao
 * @since 2018-07-22
 */
public abstract class BasePrototype implements Cloneable {

    /**
     * 自定义输出
     */
    public abstract void show();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
