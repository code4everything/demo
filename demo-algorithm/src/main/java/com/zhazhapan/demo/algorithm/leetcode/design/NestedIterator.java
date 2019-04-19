package com.zhazhapan.demo.algorithm.leetcode.design;

import com.zhazhapan.demo.algorithm.common.annotation.LeetCode;
import com.zhazhapan.demo.algorithm.common.enums.Difficulty;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pantao
 * @since 2019/4/19
 **/
@LeetCode(id = 341, title = "扁平化嵌套列表迭代器", difficulty = Difficulty.MEDIUM)
public class NestedIterator implements Iterator<Integer> {

    private int curr = 0;

    private Deque<NestedIntegerState> stack = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        new NestedIntegerState(nestedList);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedIntegerState state = stack.peek();
            if (state.hasValue()) {
                return true;
            }
            stack.pop();
        }
        return false;
    }

    @Override
    public Integer next() {
        NestedIntegerState state = stack.peek();
        NestedInteger integer = state.list.get(state.curr);
        state.curr++;
        return integer.getInteger();
    }

    class NestedIntegerState {

        public List<NestedInteger> list;

        public int curr = 0;


        NestedIntegerState(List<NestedInteger> list) {
            this.list = list;
            if (!list.isEmpty()) {
                stack.push(this);
            }
        }

        boolean hasValue() {
            while (curr < list.size()) {
                NestedInteger integer = list.get(curr);
                if (integer.isInteger()) {
                    return true;
                } else {
                    curr++;
                    List<NestedInteger> list = integer.getList();
                    if (!list.isEmpty()) {
                        NestedIntegerState state = new NestedIntegerState(list);
                        return state.hasValue();
                    }
                }
            }
            return false;
        }
    }
}
