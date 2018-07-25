package com.zhazhapan.demo.pattern.interpreter;

import com.zhazhapan.util.Checker;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class TerminalExpression implements Expression{

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return Checker.isNotNull(context) && context.contains(data);
    }
}
