package org.code4everything.demo.pattern.prototype;

/**
 * @author pantao
 * @since 2018-07-22
 */
public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        BasePrototype prototype = new ConcretePrototype();
        BasePrototype basePrototype = (BasePrototype) prototype.clone();
        basePrototype.show();
    }
}
