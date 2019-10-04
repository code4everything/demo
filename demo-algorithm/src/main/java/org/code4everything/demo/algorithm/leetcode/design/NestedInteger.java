package org.code4everything.demo.algorithm.leetcode.design;

import java.util.List;

/**
 * @author pantao
 * @since 2019/4/19
 **/
public interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
