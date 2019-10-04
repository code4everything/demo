package org.code4everything.demo.pattern.interpreter;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author pantao
 * @since 2018-07-25
 */
public class TerminalExpression implements Expression {

    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return ObjectUtil.isNotNull(context) && context.contains(data);
    }
}
