package org.code4everything.demo.pattern.interpreter;

/**
 * @author pantao
 * @since 2018-07-25
 */
public interface Expression {

    boolean interpret(String context);
}
