package org.code4everything.demo.guava.base;

import com.google.common.base.Preconditions;

/**
 * 前置条件，参数校验
 *
 * @author pantao
 * @since 2018/11/7
 **/
public class PreconditionsDemo {

    public static void main(String[] args) {
        // 检查索引位置是否合法（可以取到Size）
        Preconditions.checkPositionIndex(1, 2, "");
        // 检查索引位置是否合法
        Preconditions.checkElementIndex(1, 2, "index out of bound");
        // 自定义表达式参数校验
        Preconditions.checkArgument(Math.random() > 0, "param must great than 0");
    }
}
