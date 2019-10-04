package org.code4everything.demo.guava.basic;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * 前置条件
 *
 * @author pantao
 * @since 2018/11/7
 **/
public class Precondition {

    public static void main(String[] args) {
        Precondition precondition = new Precondition();
        precondition.checkArgument(7);
        precondition.checkNotNull("99");
        precondition.checkElementIndex(0, Lists.newArrayList(1).size());
        precondition.checkPositionIndex(1, Lists.newArrayList(3).size());
    }

    private void checkPositionIndex(int index, int size) {
        Preconditions.checkPositionIndex(index, size, "");
    }

    private void checkElementIndex(int index, int size) {
        Preconditions.checkElementIndex(index, size, "index out of bound");
    }

    private void checkNotNull(Object object) {
        Preconditions.checkNotNull(object, "object must not be null");
    }

    private void checkArgument(int param) {
        Preconditions.checkArgument(param > 0, "param must great than 0");
    }
}
